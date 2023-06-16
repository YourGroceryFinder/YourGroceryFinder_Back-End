package dev.YGC.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests ()
                .requestMatchers ("/GetAllProducts").authenticated()
                .requestMatchers ("/GetProductsBySearch").authenticated()
                .requestMatchers("/hello").permitAll()
                .and().cors()
                .and().oauth2ResourceServer().jwt();
        return http.build();
    }
}
