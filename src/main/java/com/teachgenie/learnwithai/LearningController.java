package com.teachgenie.learnwithai;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/learn")
@RequiredArgsConstructor
public class LearningController {

    private final OllamaService ollamaService;

    @GetMapping("/explain")
    public ResponseEntity<String> explainConcept(@RequestParam String topic) {
        String response = ollamaService.ask(topic);
        return ResponseEntity.ok(response);
    }
}