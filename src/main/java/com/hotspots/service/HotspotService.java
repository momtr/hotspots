package com.hotspots.service;

import com.hotspots.dto.Location;
import com.hotspots.dto.NearHotspot;
import com.hotspots.model.Hotspot;

import java.util.List;

public interface HotspotService {

    void createHotspot(Hotspot hotspot);

    List<Hotspot> findAllHotspots();

    Hotspot findHotspotById(long id);

    List<NearHotspot> findClosestHotspots(Location location, int limit);

    List<NearHotspot> findClosestHotspots(Location location);

    List<Hotspot> findAllHotspotsByCategory(String category);

}
