package com.education.edunia.agents.orchestration;

import com.education.edunia.agents.contracts.DomainAgent;
import com.education.edunia.agents.model.AgentRequest;

public interface AgentRegistry {
    DomainAgent resolve(AgentRequest request);
}
