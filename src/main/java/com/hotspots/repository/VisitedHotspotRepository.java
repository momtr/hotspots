package com.hotspots.repository;

import com.hotspots.model.Hotspot;
import com.hotspots.model.VisitedHotspot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitedHotspotRepository extends JpaRepository<VisitedHotspot, Long> {

    List<VisitedHotspot> findAll();

    List<VisitedHotspot> findAllByHotspot(Hotspot hotspot);

}
