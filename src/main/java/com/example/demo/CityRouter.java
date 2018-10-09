package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


@Configuration
@EnableWebFlux
public class CityRouter implements WebFluxConfigurer {

    @Bean
    public RouterFunction<ServerResponse> route(CityHandler handler) {
        return RouterFunctions
                .route(GET("/cities").and(accept(APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/cities/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById);
    }

}