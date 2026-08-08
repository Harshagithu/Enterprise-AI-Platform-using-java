package com.harsha.enterprise_ai_platform.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;
    private final PromptService promptService;

    public ChatService(
            ChatClient chatClient,
            PromptService promptService) {

        this.chatClient = chatClient;
        this.promptService = promptService;
    }

    public String chat(
            String conversationId,
            String topic,
            String level,
            String language) {

        String systemPrompt =
                promptService.createJavaTrainerPrompt(
                        topic,
                        level,
                        language);

        return chatClient
                .prompt()
                .system(systemPrompt)
                .user(topic)
                .advisors(advisor -> advisor.param(
                        ChatMemory.CONVERSATION_ID,
                        conversationId))
                .call()
                .content();
    }
}