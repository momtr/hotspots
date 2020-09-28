package com.hotspots.dto.mapper;

import com.hotspots.dto.NearHotspot;
import com.hotspots.model.Hotspot;

public class NearHotspotMapper {

    public static Hotspot mapNearHotspotToHotspot(NearHotspot hotspot) {
        return Hotspot.builder()
                .id(hotspot.getId())
                .name(hotspot.getName())
                .description(hotspot.getDescription())
                .category(hotspot.getCategory())
                .address(hotspot.getAddress())
                .zip(hotspot.getZip())
                .city(hotspot.getCity())
                .email(hotspot.getEmail())
                .url(hotspot.getUrl())
                .phone(hotspot.getPhone())
                .longitude(hotspot.getLongitude())
                .latitude(hotspot.getLatitude())
                .createdAt(hotspot.getCreatedAt())
                .build();
    }

}
