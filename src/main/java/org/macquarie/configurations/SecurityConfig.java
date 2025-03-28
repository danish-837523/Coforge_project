package org.macquarie.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeHttpRequests()
                    .antMatchers("/api/macquaire/**")
                    .authenticated().anyRequest().permitAll();
            return http.build();
    }
}
