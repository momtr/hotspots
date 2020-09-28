package com.hotspots.service;

import com.hotspots.dto.Location;
import com.hotspots.dto.NearHotspot;
import com.hotspots.model.Hotspot;
import com.hotspots.model.UserQuery;
import com.hotspots.model.VisitedHotspot;
import com.hotspots.repository.HotspotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotspotServiceImpl implements HotspotService {

    private static final int DEFAULT_LIMIT = 5;

    @Autowired
    private HotspotRepository hotspotRepository;

    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private VisitedHotspotService visitedHotspotService;

    @Override
    public void createHotspot(Hotspot hotspot) {
        hotspotRepository.save(hotspot);
    }

    @Override
    public List<Hotspot> findAllHotspots() {
        return hotspotRepository.findAll();
    }

    @Override
    public Hotspot findHotspotById(long id) {
        return hotspotRepository.findById(new Long(id)).get();
    }

    @Override
    public List<NearHotspot> findClosestHotspots(Location location, int limit) {
        UserQuery userQuery = userQueryService.createQuery(location);
        Pageable pageable = PageRequest.of(0, limit);
        List<NearHotspot> nearHotspots = hotspotRepository.findClosestHotspots(location.getLongitude(), location.getLatitude(), pageable);
        nearHotspots.forEach(nearHotspot -> visitedHotspotService.checkAndPersistVisit(nearHotspot, userQuery));
        return nearHotspots;
    }

    @Override
    public List<NearHotspot> findClosestHotspots(Location location) {
        return this.findClosestHotspots(location, HotspotServiceImpl.DEFAULT_LIMIT);
    }


}
