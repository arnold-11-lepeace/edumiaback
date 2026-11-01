package com.education.edunia.agents.model;

import java.util.Map;

public record ToolCall(
        String toolKey,
        Map<String, Object> input,
        String status
) {
    public ToolCall {
        if (toolKey == null || toolKey.trim().isEmpty()) {
            throw new IllegalArgumentException("toolKey is required");
        }
        if (input == null) {
            input = Map.of();
        }
        if (status == null) {
            status = "UNKNOWN";
        }
    }
}
