package com.sistema_facturacion.GRUPITO_5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// ESTA CLASE ES DE CONFIGURACION , LEELO CUANDO ARRANQUES NOS FACILITA LA CREACIONS DE BEANS O INSTANCIAS
// UNA CLASE SECURYTI CONFI
@Configuration 
// ACTIVAMOS EL SPRING SECURITY
@EnableWebSecurity

public class Security {
    // BEAN , PARA ENCRIPTAR CONTRASEÑAS (UN OBJETO QUE SE ENCARGA DEL CONTENEDOR)
    // ESTE CONTRUYE UN OBJETO Y LO GUARDA EN SPRING Y PODERLO REUTILIZAR OSEA PA UITLIZAR NUESTRO METODOS
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // CONFIGURACION PRINCIPAL DE LA SEGURIDAD

    // FILTRO DE SEGURIDAD : ANTES DE LLEGAR A LOS CONTROLADORES , COMO PARAMETRO RECIBE HTTPSECURTY Y RECIBIRA HTTP
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // DEFINIENDO AUTORIZACION AUTORIZACION DE RUTAS
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // QUE VOY A PERMITIR ACCESO....
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").hasRole("ADMIN")

                        // PETICIONES POST, PUT, DELETE SOLO PARA AADMIN
                        .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")

                        // PETICON GET PUEDE SER ADMIN O USER
                        .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("USER", "ADMIN")

                        // ALGO QUE NO ESTA AQUI OSEA FUERA DE ESTO REQUERIRA AUNTENTICACION
                        // si quiero poner pacth con esto me va funcionar si me logueo
                        .anyRequest().authenticated()
                )
                .httpBasic(org.springframework.security.config.Customizer.withDefaults());
       // RETORNAMOS EL SecurityFilter
        return http.build();
    }


}
