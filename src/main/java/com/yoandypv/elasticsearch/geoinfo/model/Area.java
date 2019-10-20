package com.yoandypv.elasticsearch.geoinfo.model;

import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "regions")
public class Area {
    @Id
    private String id;

    private String name;

    private List<GeoPoint> region;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GeoPoint> getRegion() {
        return region;
    }

    public void setRegion(List<GeoPoint> region) {
        this.region = region;
    }
}
