package com.alura.frases;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry regitro){
        regitro.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST","DELETE","OPTIONS", "HEAD","TRACE","CONNECT");
    }
}
