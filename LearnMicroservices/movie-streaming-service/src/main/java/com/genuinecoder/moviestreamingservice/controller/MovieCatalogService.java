package com.genuinecoder.moviestreamingservice.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieCatalogService {

    public static final String CATALOG_SERVICE = "http://movie-catalog-service";

    @Autowired
    private RestTemplate restTemplate;

    public String getMoviePath(Long movieInfoId) {
        var response = restTemplate.getForEntity(CATALOG_SERVICE + "/movie-info/find-path-by-id/{movieInfoId}", String.class, movieInfoId);
        return response.getBody();
    }
}
