package com.yoandypv.elasticsearch.geoinfo.repository;

import com.yoandypv.elasticsearch.geoinfo.model.Area;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AreaRepository extends ElasticsearchRepository<Area, String> {
}
