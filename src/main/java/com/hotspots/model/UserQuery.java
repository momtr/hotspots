package com.hotspots.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Builder
@AllArgsConstructor
public class UserQuery {

    public UserQuery() {
        queryDate = LocalDate.now();
        queryTime = LocalTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Double longitude;

    @NotNull
    private Double latitude;

    private LocalTime queryTime;
    private LocalDate queryDate;

}
