package com.example.ApiGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator addRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p.path("/api/v1/**")
                        .uri("http://user-authentication-container:8080/"))
                .build();

    }
}
