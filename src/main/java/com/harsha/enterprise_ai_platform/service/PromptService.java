package com.harsha.enterprise_ai_platform.service;

import org.springframework.stereotype.Service;

@Service
public class PromptService {

    public String createJavaTrainerPrompt(
            String topic,
            String level,
            String language) {

        return """
                You are a Senior Java Trainer.

                Explain the following topic:

                Topic: %s

                Difficulty Level: %s

                Language: %s

                Your response must contain:

                1. A clear definition
                2. A real-world example
                3. A practical Java example
                4. Best practices

                Keep the explanation simple and practical.
                Keep the response below 300 words.
                """.formatted(topic, level, language);
    }

    public String getCodeReviewerPrompt() {

        return """
                You are an experienced Java Code Reviewer.

                Analyze the code carefully.

                Identify:

                1. Bugs
                2. Code smells
                3. Performance problems
                4. Security concerns
                5. Improvement suggestions

                Explain each issue clearly.

                Provide improved code when necessary.
                """;
    }
}