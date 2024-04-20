package com.genuinecoder.moviecatalogservice.controller;

import com.genuinecoder.moviecatalogservice.model.MovieInfo;
import com.genuinecoder.moviecatalogservice.model.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieInfoController {

    @Autowired
    private MovieInfoRepository repository;

    @PostMapping("/movie-info/save")
    public List<MovieInfo> saveAll(@RequestBody List<MovieInfo> movieInfoList) {
        return repository.saveAll(movieInfoList);
    }

    @GetMapping("/movie-info/list")
    public List<MovieInfo> getAll() {
        return repository.findAll();
    }

    @GetMapping("/movie-info/find-path-by-id/{movieInfoId}")
    public String findPathById(@PathVariable Long movieInfoId) {
        var videoInfoOptional = repository.findById(movieInfoId);
        return videoInfoOptional.map(MovieInfo::getPath).orElse(null);
    }
}
