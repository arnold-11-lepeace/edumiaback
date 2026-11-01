package com.education.edunia.agents.contracts;

import com.education.edunia.agents.model.AgentRequest;
import com.education.edunia.agents.orchestration.AgentContext;

public interface DomainAgent {
    String name();
    boolean supports(AgentRequest request);
    Object execute(AgentRequest request, AgentContext context);
}
