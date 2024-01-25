package edu.captura.api.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//En SPring primero se escanean los archivos con la anotación "@Configuration" porqe se entiende que son pre requisitos para que otros objetos puedan ser creados
//Con @EnableWebSecurity le decimos a Spring que nos lo habilite para sobreescribir el comportamiento de autenticaión que queremos
@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    //csrf y and.build están "deprecated", por eso la anotación "@SuppressWarnings"
    @Bean
    @SuppressWarnings("removal")
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().build();
    }
}
