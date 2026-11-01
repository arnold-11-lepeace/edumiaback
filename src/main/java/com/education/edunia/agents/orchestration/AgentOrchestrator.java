package com.education.edunia.agents.orchestration;

import com.education.edunia.agents.model.AgentRequest;

public interface AgentOrchestrator {
    Object handle(AgentRequest request);
}
