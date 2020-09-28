package com.hotspots.repository;

import com.hotspots.dto.NearHotspot;
import com.hotspots.model.Hotspot;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotspotRepository extends JpaRepository<Hotspot, Long> {

    List<Hotspot> findAll();

    Optional<Hotspot> findHotspotById(Long id);

    @Query("SELECT new com.hotspots.dto.NearHotspot(h.id, h.name, h.description, h.category, h.address, h.zip, h.city, h.email, h.url, h.phone, h.longitude, h.latitude, h.createdAt, SQRT(POW(69.1 * (h.latitude - :geo_lat), 2) + POW(69.1 * (:geo_long - h.longitude) * COS(h.latitude / 57.3), 2)) AS distance) FROM Hotspot h ORDER BY distance")
    List<NearHotspot> findClosestHotspots(@Param("geo_long") Double geo_long, @Param("geo_lat") Double geo_lat, Pageable pageable);

}
