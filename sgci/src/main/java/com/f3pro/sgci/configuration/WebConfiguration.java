package com.f3pro.sgci.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {


        @Override
        public void addCorsMappings(CorsRegistry registry) {
            //registry.addMapping("/**").allowedOrigins("http://example.com");
            // ou para permitir de qualquer origem
            registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
        }
}
