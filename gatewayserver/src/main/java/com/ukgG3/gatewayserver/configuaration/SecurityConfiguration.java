package com.ukgG3.gatewayserver.configuaration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity.authorizeExchange(exchange -> exchange
//                .pathMatchers(HttpMethod.GET).permitAll()
//                .pathMatchers(HttpMethod.GET, "/application/api/applications/{id}").hasRole("MANAGER")
                .pathMatchers(HttpMethod.GET,"jobposting/api/jobPostings/getAll").hasRole("EMPLOYEE")
                .pathMatchers(HttpMethod.POST, "application/api/aplications/createApplication").hasRole("EMPLOYEE")
                .pathMatchers("/application/api/applications/**").hasRole("HR")
                .pathMatchers("/jobposting/api/jobPostings/**").hasRole("HR")
                .pathMatchers(HttpMethod.GET,"/jobposting/api/jobPostings/**").hasRole("MANGER")
                .pathMatchers(HttpMethod.GET, "/application/api/applications/**").hasRole("MANAGER")
                .pathMatchers(HttpMethod.PUT, "/application/api/applications/{id}/verifyByManager").hasRole("MANAGER")
                .pathMatchers(HttpMethod.PUT, "/application/api/applications/{id}/verifyByManagerRejected").hasRole("MANAGER")
                .pathMatchers(HttpMethod.GET, "application/api/applications/{id}").hasAnyRole("EMPLOYEE", "HR", "MANAGER")

        ).oauth2ResourceServer(config -> config.jwt(Customizer.withDefaults()));

        httpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable);

        return httpSecurity.build();
    }
}



