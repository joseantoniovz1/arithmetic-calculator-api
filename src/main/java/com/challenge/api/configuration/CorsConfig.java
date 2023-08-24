package com.challenge.api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Adjust the mapping pattern as needed
                .allowedOrigins("http://localhost:3000") // Adjust the origin to match your React app's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
