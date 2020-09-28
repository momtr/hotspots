package com.hotspots.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
public class HotspotVisit {
    private String hotspotName;
    private LocalTime queryTime;
    private LocalDate queryDate;
    private Location hotspotLocation;
    private Location userLocation;
    private Double distance;
}
