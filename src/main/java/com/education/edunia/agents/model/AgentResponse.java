package com.education.edunia.agents.model;

import java.util.List;
import java.util.Map;

public record AgentResponse(
        String agentName,
        String output,
        List<ToolCall> toolCalls,
        Map<String, Object> metadata
) {
    public AgentResponse {
        if (agentName == null || agentName.trim().isEmpty()) {
            throw new IllegalArgumentException("agentName is required");
        }
        if (output == null) {
            output = "";
        }
        if (toolCalls == null) {
            toolCalls = List.of();
        }
        if (metadata == null) {
            metadata = Map.of();
        }
    }
}
