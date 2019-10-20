package com.yoandypv.elasticsearch.geoinfo.service;

import com.yoandypv.elasticsearch.geoinfo.model.Area;
import com.yoandypv.elasticsearch.geoinfo.model.Place;
import com.yoandypv.elasticsearch.geoinfo.repository.AreaRepository;
import com.yoandypv.elasticsearch.geoinfo.repository.PlaceRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.geoPolygonQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    AreaRepository areaRepository;

    @Override
    public Place save(Place place) {
      return placeRepository.save(place);
    }

    @Override
    public List<Place> list() {
        return StreamSupport
                .stream( this.placeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Place> getPlacesInArea(String areaId) {

       Optional<Area> areaOptional = this.areaRepository.findById(areaId);

        if (areaOptional.isPresent()) {

            QueryBuilder qb = geoPolygonQuery("position", areaOptional.get().getRegion());
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(matchAllQuery()).filter(qb);

            return  StreamSupport
                    .stream( this.placeRepository.search(boolQueryBuilder).spliterator(), false)
                    .collect(Collectors.toList());
        }
         else
             return null;

    }
}
