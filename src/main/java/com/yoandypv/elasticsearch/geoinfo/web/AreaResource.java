package com.yoandypv.elasticsearch.geoinfo.web;

import com.yoandypv.elasticsearch.geoinfo.model.Area;
import com.yoandypv.elasticsearch.geoinfo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AreaResource {

    @Autowired
    private AreaService areaService;


    @RequestMapping(method = RequestMethod.POST, value = "/areas")
    public ResponseEntity<Area> save(@RequestBody Area area) {
        System.out.println(area.toString());
        return ResponseEntity.ok(areaService.save(area));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/areas")
    public ResponseEntity<List<Area>> list() {
        return ResponseEntity.ok(areaService.list());
    }
}
