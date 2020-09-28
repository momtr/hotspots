package com.hotspots.dto.mapper;

import com.hotspots.dto.HotspotVisit;
import com.hotspots.dto.Location;
import com.hotspots.model.VisitedHotspot;

public class VisitedHotspotMapper {

    public static HotspotVisit mapVisitedHotspotToHotspotVisit(VisitedHotspot visitedHotspot) {
        Location hotspotLocation = Location.builder()
                .longitude(visitedHotspot.getHotspot().getLongitude())
                .latitude(visitedHotspot.getHotspot().getLatitude())
                .build();
        Location userLocation = Location.builder()
                .longitude(visitedHotspot.getUserQuery().getLongitude())
                .latitude(visitedHotspot.getUserQuery().getLatitude())
                .build();
        return HotspotVisit.builder()
                .hotspotLocation(hotspotLocation)
                .userLocation(userLocation)
                .distance(visitedHotspot.getDistance())
                .hotspotName(visitedHotspot.getHotspot().getName())
                .queryDate(visitedHotspot.getUserQuery().getQueryDate())
                .queryTime(visitedHotspot.getUserQuery().getQueryTime())
                .build();
    }

}
