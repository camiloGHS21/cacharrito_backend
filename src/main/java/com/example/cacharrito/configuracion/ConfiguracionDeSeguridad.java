package com.example.cacharrito.configuracion;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.cacharrito.servicios.ServicioMiDetallesDeUsuario;

@Configuration
@EnableWebSecurity
public class ConfiguracionDeSeguridad {

	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Deshabilitar CSRF si estás trabajando con APIs
            .authorizeRequests()
                .requestMatchers(
                		"/api/usuarios/guardar",
                		"/api/reservaciones/verTodos",
                		"/api/disponibilidad/verTodos",
                		"/api/automoviles/verTodos",
                		"/api/disponibilidad/actualizar"     		
                		)
                .permitAll() // Permite el acceso a cualquier usuario a las rutas bajo /api/public/
                .anyRequest().authenticated() // Todas las demás solicitudes requieren autenticación
                .and()
            .httpBasic(); // Habilita la autenticación básica
        return http.build();
    }

    // Configuración del AuthenticationManager
    @Bean
    public org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration authenticationConfiguration() {
        return new org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration();
    }
    // Bean para exponer el AuthenticationManager
    @Bean
    public org.springframework.security.authentication.AuthenticationManager authenticationManager(
            org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

