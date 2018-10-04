package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class helloController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<City> all() {
        return cityRepository.findAll()
                .log();
    }
}
