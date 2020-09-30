package com.hotspots.controller;

import com.hotspots.dto.Location;
import com.hotspots.model.Hotspot;
import com.hotspots.service.HotspotService;
import com.hotspots.service.VisitedHotspotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LocationController {

    @Autowired
    private HotspotService hotspotService;

    @Autowired
    private VisitedHotspotService visitedHotspotService;

    @GetMapping("/hotspots")
    public ResponseEntity<Object> getClosestHotspots(@RequestBody Location location) {
        return new ResponseEntity<>(hotspotService.findClosestHotspots(location, 5), HttpStatus.OK);
    }

    @GetMapping("/hotspots/{id}")
    public ResponseEntity<Object> getHotspotById(@PathVariable long id) {
        return new ResponseEntity<>(hotspotService.findHotspotById(id), HttpStatus.OK);
    }

    @GetMapping("/hotspots/{id}/visits")
    public ResponseEntity<Object> getVisitedHotspotsByHotspotId(@PathVariable long id) {
        return new ResponseEntity<>(visitedHotspotService.findAllByHotspotsId(id), HttpStatus.OK);
    }

    @GetMapping("/hotspots/top")
    public ResponseEntity<Object> getTopHotspots() {
        return new ResponseEntity<>(visitedHotspotService.findTopHotspots(), HttpStatus.OK);
    }

    @PostMapping("/hotspots")
    public ResponseEntity<Object> postHotspot(@Valid @RequestBody Hotspot hotspot) {
        hotspotService.createHotspot(hotspot);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
