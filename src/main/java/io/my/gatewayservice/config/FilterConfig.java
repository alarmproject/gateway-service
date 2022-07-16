package io.my.gatewayservice.config;

import io.my.gatewayservice.FilterConfigEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Value("uri")
    private String uri;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route.path("/api/user/**")
                        .filters(filter ->filter
                                .addRequestHeader(FilterConfigEnum.GATEWAY_REQUEST.getValue(), "dev-user-request")
                                .addRequestHeader(FilterConfigEnum.GATEWAY_RESPONSE.getValue(), "dev-user-response")
                                .rewritePath("/api/user/(?<segment>.*)", FilterConfigEnum.REPLACEMENT.getValue())
                        ).uri(uri + ":7000/")
                ).route(route -> route.path("/image/**")
                                .filters(filter ->filter
                                        .addRequestHeader(FilterConfigEnum.GATEWAY_REQUEST.getValue(), "dev-image-request")
                                        .addRequestHeader(FilterConfigEnum.GATEWAY_RESPONSE.getValue(), "dev-image-response")
                                        .rewritePath("/image/(?<segment>.*)", FilterConfigEnum.REPLACEMENT.getValue())
                                ).uri(uri + ":7001/")
                ).route(route -> route.path("/api/calender/**")
                                .filters(filter ->filter
                                        .addRequestHeader(FilterConfigEnum.GATEWAY_REQUEST.getValue(), "dev-calender-request")
                                        .addRequestHeader(FilterConfigEnum.GATEWAY_RESPONSE.getValue(), "dev-calender-response")
                                        .rewritePath("/api/calender/(?<segment>.*)", FilterConfigEnum.REPLACEMENT.getValue())
                                ).uri(uri + ":7002/")
                ).build();
    }


}
