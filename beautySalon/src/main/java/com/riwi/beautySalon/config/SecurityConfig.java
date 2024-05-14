package com.riwi.beautySalon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Anotacion de configuracion - Activa spring security esta clase
@EnableWebSecurity
public class SecurityConfig {

    // Crear rutas publicas
    // Todo lo que siga despues de auth los "**" va a ser publico
    private final String[] PUBLIC_RESOURCES = {"/services/public/get", "/auth/**"};

    /*
     *@Bean Anotation: Esta anotacion le indica a Spring boot que el objeto retornado por el metodo
     debe ser registrado como un Bean en el contexto de Spring 
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // En caso de que falle lanzara un error throws Exception 

        return http
                .csrf(csrf -> csrf.disable()) // Desabilitar proteccion csrf - 
                .authorizeHttpRequests(authRequest -> authRequest
                    .requestMatchers(PUBLIC_RESOURCES).permitAll() // Configurar rutas publicas
                    .anyRequest().authenticated()
                ).build();
    }
}
