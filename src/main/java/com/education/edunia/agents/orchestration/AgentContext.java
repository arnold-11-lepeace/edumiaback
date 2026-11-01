package com.education.edunia.agents.orchestration;

import java.util.Map;

public record AgentContext(
        String schoolId,
        String userId,
        String correlationId,
        Map<String, Object> attributes
) {
    public AgentContext {
        if (attributes == null) {
            attributes = Map.of();
        }
    }
}
