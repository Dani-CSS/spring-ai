package com.daniele.api_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotNull;

public class ChatController {

    private final ChatClient chatClient;

    public ChatController(@NotNull ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ai")
    String generation(String userInput) {
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }


}
