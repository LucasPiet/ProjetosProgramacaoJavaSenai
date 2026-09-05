package br.com.senai.cadastroamigos.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMapping(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("http://localHost:3000", "http://127.0.0.1:3000","http://localHost:5500", "http://127.0.0.1:5500")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
    }

