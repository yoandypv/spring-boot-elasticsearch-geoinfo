package com.yoandypv.elasticsearch.geoinfo.web;

import com.yoandypv.elasticsearch.geoinfo.model.Place;
import com.yoandypv.elasticsearch.geoinfo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlaceResource {

    @Autowired
    private PlaceService placeService;


    @RequestMapping(method = RequestMethod.POST, value = "/places")
    public ResponseEntity<Place> save(@RequestBody Place place) {
        System.out.println(place.toString());
            return ResponseEntity.ok(placeService.save(place));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/places/regionId/{regionId}")
    public ResponseEntity<List<Place>> list(@PathVariable("regionId") String regionId) {
        return ResponseEntity.ok(placeService.getPlacesInArea(regionId));
    }
}
