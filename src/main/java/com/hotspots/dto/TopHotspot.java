package com.hotspots.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TopHotspot {
    private String hotspotName;
    private Long hotspotId;
    private Double avgDistance;
    private Long numOfVisits;
}
