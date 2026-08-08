package com.harsha.enterprise_ai_platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(
            ChatClient.Builder builder,
            MessageChatMemoryAdvisor memoryAdvisor) {

        return builder
                .defaultAdvisors(memoryAdvisor)
                .build();
    }
}