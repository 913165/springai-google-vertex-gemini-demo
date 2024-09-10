package com.example.springaidemogemini.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {
    ChatClient chatClient;

    public AIController(ChatClient.Builder chatClientBuilder) {
        chatClient = chatClientBuilder.build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(value = "message",defaultValue = "what is the capital of India ?")  String message) {
        return chatClient.prompt().user(message).call().chatResponse().getResult().getOutput().getContent();
    }
}
