package com.hotspots.service;

import com.hotspots.dto.HotspotVisit;
import com.hotspots.dto.NearHotspot;
import com.hotspots.model.UserQuery;
import com.hotspots.model.VisitedHotspot;

import java.util.List;

public interface VisitedHotspotService {

    void persistVist(NearHotspot nearHotspot, UserQuery userQuery);

    void checkAndPersistVisit(NearHotspot nearHotspot, UserQuery userQuery);

    List<VisitedHotspot> findAll();

    List<HotspotVisit> findAllByHotspotsId(long id);

}
