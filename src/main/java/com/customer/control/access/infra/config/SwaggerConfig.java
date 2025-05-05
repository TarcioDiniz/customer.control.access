package com.customer.control.access.infra.config;

import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.Desktop;
import java.net.URI;
import java.util.Comparator;

@Configuration
public class SwaggerConfig {

    @Value("${server.port:8080}")
    private int port;

    @Bean
    public CommandLineRunner openSwaggerOnStartup() {
        return args -> {
            // só tenta abrir se o Desktop suportar
            if (Desktop.isDesktopSupported()) {
                String url = "http://localhost:" + port + "/swagger-ui/index.html";
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception e) {
                    System.err.println("Não foi possível abrir o browser: " + e.getMessage());
                }
            } else {
                System.out.println("Abra manualmente: http://localhost:" + port + "/swagger-ui/index.html");
            }
        };
    }

    @Bean
    public OpenApiCustomizer sortTagsAlphabetically() {
        return openApi -> {
            if (openApi.getTags() != null) {
                openApi.getTags().sort(Comparator.comparing(Tag::getName, String.CASE_INSENSITIVE_ORDER));
            }
        };
    }
}