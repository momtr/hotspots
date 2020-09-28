package com.hotspots.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class NearHotspot {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String address;
    private Integer zip;
    private String city;
    private String email;
    private String url;
    private String phone;
    private Double longitude;
    private Double latitude;
    private LocalDate createdAt;
    private Double distance;
}
