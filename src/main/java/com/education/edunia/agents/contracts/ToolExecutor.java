package com.education.edunia.agents.contracts;

import com.education.edunia.agents.orchestration.AgentContext;

public interface ToolExecutor {
    Object invoke(String toolKey, Object input, AgentContext context);
}
