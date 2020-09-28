package com.hotspots.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Hotspot {

    public Hotspot() {
        createdAt = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @Column(length = 512)
    private String description;

    private String category;

    private String address;

    private Integer zip;

    private String city;

    private String email;

    private String url;

    private String phone;

    @NotNull
    private Double longitude;

    @NotNull
    private Double latitude;

    private LocalDate createdAt;

}
