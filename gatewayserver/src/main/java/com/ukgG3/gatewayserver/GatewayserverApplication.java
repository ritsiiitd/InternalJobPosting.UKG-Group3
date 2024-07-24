package com.ukgG3.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}


	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("job-posting-service", p -> p.path("/api/jobPostings/**", "/api/employees/**","/api/jobpost/**")
						.uri("lb://jobposting"))
				.route("application-service", p -> p.path("/api/applications/**")
						.uri("lb://application"))
				.build();
	}
}
