package com.topicos.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeHttpRequests(authorize -> authorize
    //             .requestMatchers("/public/**").permitAll() // Permite acesso público para qualquer rota que comece com /public
    //             .anyRequest().authenticated() // Requer autenticação para todas as outras requisições
    //         )
    //         .oauth2ResourceServer(oauth2 -> oauth2
    //             .jwt(jwt -> jwt
    //                 .jwkSetUri("http://localhost:8090/realms/tees/protocol/openid-connect/certs") // URI do conjunto de chaves JWK do Keycloak
    //             )
    //         );
    //     return http.build();
    // }
}
