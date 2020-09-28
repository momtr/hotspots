package com.hotspots.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
public class VisitedHotspot {

    public VisitedHotspot() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotspot_id", referencedColumnName = "id")
    @Nullable
    private Hotspot hotspot;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name =" user_query_id", referencedColumnName = "id")
    @Nullable
    private UserQuery userQuery;

    private Double distance;

}
