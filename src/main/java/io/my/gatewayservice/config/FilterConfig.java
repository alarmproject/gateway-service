package io.my.gatewayservice.config;

import io.my.gatewayservice.FilterConfigEnum;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route.path("/api/user/**")
                        .filters(filter ->filter
                                .addRequestHeader(FilterConfigEnum.GATEWAY_REQUEST.getValue(), "dev-user-request")
                                .addRequestHeader(FilterConfigEnum.GATEWAY_RESPONSE.getValue(), "dev-user-response")
                                .rewritePath("/api/user/(?<segment>.*)", FilterConfigEnum.REPLACEMENT.getValue())
                        ).uri(FilterConfigEnum.URI.getValue() + ":7000/")
                ).route(route -> route.path("/api/image/**")
                                .filters(filter ->filter
                                        .addRequestHeader(FilterConfigEnum.GATEWAY_REQUEST.getValue(), "dev-image-request")
                                        .addRequestHeader(FilterConfigEnum.GATEWAY_RESPONSE.getValue(), "dev-image-response")
                                        .rewritePath("/api/image/(?<segment>.*)", FilterConfigEnum.REPLACEMENT.getValue())
                                ).uri(FilterConfigEnum.URI.getValue() + ":7001/")
//                ).route(route -> route.path("/live/api/user/**")
//                        .filters(filter ->filter
//                                .addRequestHeader("gateway-request", "live-user-request")
//                                .addRequestHeader("gateway-response", "live-user-response")
//                                .rewritePath("/live/api/user/(?<segment>.*)", "/$\\{segment}")
//                        ).uri("lb://LIVE-USER-SERVICE")
                ).build();
    }


}
