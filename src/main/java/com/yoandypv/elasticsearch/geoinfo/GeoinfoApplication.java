package com.yoandypv.elasticsearch.geoinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;

@SpringBootApplication(exclude={ElasticsearchAutoConfiguration.class, RestClientAutoConfiguration.class})
public class GeoinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoinfoApplication.class, args);
	}

}
