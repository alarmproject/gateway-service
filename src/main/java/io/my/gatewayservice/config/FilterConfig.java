package io.my.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route.path("/dev/api/user/**")
                        .filters(filter ->filter
                                .addRequestHeader("gateway-request", "dev-user-request")
                                .addRequestHeader("gateway-response", "dev-user-response")
                                .rewritePath("/dev/api/user/(?<segment>.*)", "/$\\{segment}")
                        ).uri("http://mysend.co.kr:7000/")
//                ).route(route -> route.path("/live/api/user/**")
//                        .filters(filter ->filter
//                                .addRequestHeader("gateway-request", "live-user-request")
//                                .addRequestHeader("gateway-response", "live-user-response")
//                                .rewritePath("/live/api/user/(?<segment>.*)", "/$\\{segment}")
//                        ).uri("lb://LIVE-USER-SERVICE")
                ).build();
    }


}
