package com.enesdeniz.emlakburadagateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class GatewayConfiguration {

    @Bean
    RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                //User Controller routing(EmlakBurada)
                .route(predicateSpec -> predicateSpec.method(HttpMethod.GET).and()
                    .path("/users")
                        .uri("http://localhost:8080/users"))
                .route(predicateSpec -> predicateSpec.method(HttpMethod.POST).and()
                    .path("/users")
                        .uri("http://localhost:8080/users"))

                //Advert Controller routing(EmlakBurada)
                .route(predicateSpec -> predicateSpec.method(HttpMethod.GET).and()
                    .path("/adverts")
                        .uri("http://localhost:8080/advert"))
                .route(predicateSpec -> predicateSpec.method(HttpMethod.POST).and()
                    .path("/adverts")
                        .uri("http://localhost:8080/advert"))
                .route(predicateSpec -> predicateSpec.method(HttpMethod.POST).and()
                    .path("/adverts/{advertNo}")
                        .uri("http://localhost:8080/adverts/{advertNo}"))

                //Banner Controller routing (EmlakBurada-Banner)
                .route(predicateSpec -> predicateSpec.method(HttpMethod.GET).and()
                    .path("/banners")
                        .uri("http://localhost:8081/users"))
                .route(predicateSpec -> predicateSpec.method(HttpMethod.POST).and()
                    .path("/banners")
                        .uri("http://localhost:8081/users"))
                .build();

    }
}
