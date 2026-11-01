package com.education.edunia.agents.model;

import java.util.Map;

public record AgentRequest(
        String agentKey,
        String task,
        String schoolId,
        String userId,
        String correlationId,
        Map<String, Object> metadata
) {
    public AgentRequest {
        if (isBlank(agentKey)) {
            throw new IllegalArgumentException("agentKey is required");
        }
        if (isBlank(task)) {
            throw new IllegalArgumentException("task is required");
        }
        if (isBlank(schoolId)) {
            throw new IllegalArgumentException("schoolId is required");
        }
        if (isBlank(userId)) {
            throw new IllegalArgumentException("userId is required");
        }
        if (metadata == null) {
            metadata = Map.of();
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
