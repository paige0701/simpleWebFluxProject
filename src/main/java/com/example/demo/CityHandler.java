package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class CityHandler {

    private final CityRepository cityRepository;

    public CityHandler(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(APPLICATION_JSON)
                .body(cityRepository.findById(id), City.class).log();
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {

        Flux<City> cities = cityRepository.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(cities, City.class);
    }
}
