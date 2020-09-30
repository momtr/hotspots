package com.hotspots.repository;

import com.hotspots.dto.TopHotspot;
import com.hotspots.model.Hotspot;
import com.hotspots.model.VisitedHotspot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface VisitedHotspotRepository extends JpaRepository<VisitedHotspot, Long> {

    List<VisitedHotspot> findAll();

    List<VisitedHotspot> findAllByHotspot(Hotspot hotspot);

    @Query("SELECT new com.hotspots.dto.TopHotspot(h.name, h.id, (SUM(v.distance)/COUNT(v.distance)) AS distance, COUNT(h) AS num) FROM Hotspot h LEFT JOIN VisitedHotspot v ON v.hotspot = h GROUP BY h ORDER BY num DESC")
    List<TopHotspot> findAllTopHotspots(Pageable pageable);

}
