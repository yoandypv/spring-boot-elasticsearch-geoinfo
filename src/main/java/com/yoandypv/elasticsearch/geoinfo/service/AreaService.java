package com.yoandypv.elasticsearch.geoinfo.service;

import com.yoandypv.elasticsearch.geoinfo.model.Area;

import java.util.List;

public interface AreaService {
    Area save(Area area);
    List<Area> list();
}
