package com.yoandypv.elasticsearch.geoinfo.service;

import com.yoandypv.elasticsearch.geoinfo.model.Area;
import com.yoandypv.elasticsearch.geoinfo.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;


    @Override
    public Area save(Area area) {
        return this.areaRepository.save(area);
    }

    @Override
    public List<Area> list() {
        return  StreamSupport
                .stream( this.areaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
