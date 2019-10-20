package com.yoandypv.elasticsearch.geoinfo.repository;

import com.yoandypv.elasticsearch.geoinfo.model.Place;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PlaceRepository extends ElasticsearchRepository<Place, String> {
}
