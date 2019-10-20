package com.yoandypv.elasticsearch.geoinfo.service;

import com.yoandypv.elasticsearch.geoinfo.model.Place;

import java.util.List;

public interface PlaceService {
    Place save(Place place);
    List<Place> list();
    List<Place> getPlacesInArea(String areaId);
}
