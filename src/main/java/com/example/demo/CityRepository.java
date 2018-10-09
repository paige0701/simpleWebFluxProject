package com.example.demo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CityRepository extends ReactiveCrudRepository<City, String> {

}
