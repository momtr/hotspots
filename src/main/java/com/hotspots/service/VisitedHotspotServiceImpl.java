package com.hotspots.service;

import com.hotspots.dto.HotspotVisit;
import com.hotspots.dto.NearHotspot;
import com.hotspots.dto.TopHotspot;
import com.hotspots.dto.mapper.NearHotspotMapper;
import com.hotspots.dto.mapper.VisitedHotspotMapper;
import com.hotspots.model.Hotspot;
import com.hotspots.model.UserQuery;
import com.hotspots.model.VisitedHotspot;
import com.hotspots.repository.VisitedHotspotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitedHotspotServiceImpl implements VisitedHotspotService {

    private static final double MAX_DISTANCE_FOR_VISIT = 0.05;
    private static final int DEFAULT_LIMIT = 5;

    @Autowired
    private VisitedHotspotRepository visitedHotspotRepository;

    @Autowired
    private HotspotService hotspotService;

    @Override
    public void persistVist(NearHotspot nearHotspot, UserQuery userQuery) {
        VisitedHotspot visitedHotspot = VisitedHotspot.builder()
                .distance(nearHotspot.getDistance())
                .hotspot(NearHotspotMapper.mapNearHotspotToHotspot(nearHotspot))
                .userQuery(userQuery)
                .build();
        visitedHotspotRepository.save(visitedHotspot);
    }

    @Override
    public void checkAndPersistVisit(NearHotspot nearHotspot, UserQuery userQuery) {
        if (nearHotspot.getDistance().doubleValue() < VisitedHotspotServiceImpl.MAX_DISTANCE_FOR_VISIT)
            this.persistVist(nearHotspot, userQuery);
    }

    @Override
    public List<VisitedHotspot> findAll() {
        return visitedHotspotRepository.findAll();
    }

    @Override
    public List<HotspotVisit> findAllByHotspotsId(long id) {
        Hotspot hotspot = hotspotService.findHotspotById(id);
        return visitedHotspotRepository.findAllByHotspot(hotspot)
                .stream()
                .map(visitedHotspot -> VisitedHotspotMapper.mapVisitedHotspotToHotspotVisit(visitedHotspot))
                .collect(Collectors.toList());
    }

    @Override
    public List<TopHotspot> findTopHotspots(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return visitedHotspotRepository.findAllTopHotspots(pageable);
    }

    @Override
    public List<TopHotspot> findTopHotspots() {
        return this.findTopHotspots(VisitedHotspotServiceImpl.DEFAULT_LIMIT);
    }


}
