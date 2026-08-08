package com.harsha.enterprise_ai_platform.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsha.enterprise_ai_platform.dto.ChatRequest;
import com.harsha.enterprise_ai_platform.dto.ChatResponse;
import com.harsha.enterprise_ai_platform.service.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse chat(
            @Valid @RequestBody ChatRequest request) {

        String response =
                chatService.chat(
                        request.getConversationId(),
                        request.getTopic(),
                        request.getLevel(),
                        request.getLanguage());

        return new ChatResponse(response);
    }
}