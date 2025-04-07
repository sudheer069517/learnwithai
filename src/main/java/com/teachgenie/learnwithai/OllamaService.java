package com.teachgenie.learnwithai;

import com.teachgenie.learnwithai.config.OllamaConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OllamaService {

    private final OllamaConfig config;
    private final RestTemplate restTemplate = new RestTemplate();

    public String ask(String userPrompt) {
        String url = config.getUrl() + "/api/generate";

        Map<String, Object> requestBody = Map.of(
                "model", config.getModel(),
                "prompt", "Explain to a 9-year-old: " + userPrompt,
                "stream", false
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);
        return (String) response.getBody().get("response");
    }
}
