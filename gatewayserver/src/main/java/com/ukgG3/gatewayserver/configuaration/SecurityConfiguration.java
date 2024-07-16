package com.ukgG3.gatewayserver.configuaration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity.authorizeExchange(exchange -> exchange
//                .pathMatchers(HttpMethod.GET).permitAll()
//                .pathMatchers(HttpMethod.GET, "/application/api/applications/{id}").hasRole("MANAGER")
                //JOB POSTING API'S
                .pathMatchers(HttpMethod.GET,"jobposting/api/jobPostings/getAllJobs").hasRole("EMPLOYEE")
                .pathMatchers(HttpMethod.GET,"jobposting/api/jobPostings/getJobById").hasRole("EMPLOYEE")
                .pathMatchers(HttpMethod.POST,"jobposting/api/jobPostings/**").hasRole("HR")
                .pathMatchers(HttpMethod.DELETE,"jobposting/api/jobPostings/deleteJob").hasRole("HR")
                .pathMatchers(HttpMethod.PUT,"jobposting/api/jobPostings/closeJobPosting").hasRole("HR")

                //APPLICATIONS APIS


                .pathMatchers(HttpMethod.GET,"/application/api/applications/**").hasAnyRole("HR", "MANAGER")
                .pathMatchers(HttpMethod.POST, "/application/api/applications/createApplications").hasAnyRole("EMPLOYEE","HR", "MANAGER")
                .pathMatchers(HttpMethod.DELETE,"/application/api/applications/{id}").hasRole("HR")
                .pathMatchers(HttpMethod.PUT, "/application/api/applications/{id}/verifyByManager").hasRole("MANAGER")
                .pathMatchers(HttpMethod.PUT, "/application/api/applications/{id}/verifyByManagerRejected").hasRole("MANAGER")

                //EMployees APi
//                        .pathMatchers(HttpMethod.GET,"/jobposting/api/employees/getAll").permitAll()
                .pathMatchers(HttpMethod.GET, "/jobposting/api/employees/**").hasRole("HR")
                .pathMatchers(HttpMethod.PUT, "/jobposting/api/employees/getById").hasRole("EMPLOYEE")
        ).oauth2ResourceServer(config -> config.jwt(spec -> spec.jwtAuthenticationConverter(grantedAuthorityExtractor())));

        httpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable);

        return httpSecurity.build();
    }
    private Converter<Jwt, Mono<AbstractAuthenticationToken>> grantedAuthorityExtractor(){
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }

}

