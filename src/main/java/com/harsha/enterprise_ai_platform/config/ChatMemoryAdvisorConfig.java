package com.harsha.enterprise_ai_platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;

@Configuration
public class ChatMemoryAdvisorConfig {

    @Bean
    public MessageChatMemoryAdvisor chatMemoryAdvisor(
            ChatMemory chatMemory) {

        return MessageChatMemoryAdvisor
                .builder(chatMemory)
                .build();
    }
}