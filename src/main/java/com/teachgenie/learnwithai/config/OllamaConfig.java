package com.teachgenie.learnwithai.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ollama")
@Getter
@Setter
public class OllamaConfig {
    private String url;
    private String model;
}
