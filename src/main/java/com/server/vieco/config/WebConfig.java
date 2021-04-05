package com.server.vieco.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://ec2-3-36-231-201.ap-northeast-2.compute.amazonaws.com:8080/api/car/electric/station")
                .allowedOrigins("localhost:3000");
    }
}
