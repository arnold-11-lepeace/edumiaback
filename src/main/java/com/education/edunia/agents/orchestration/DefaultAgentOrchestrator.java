package com.education.edunia.agents.orchestration;

import com.education.edunia.agents.contracts.DomainAgent;
import com.education.edunia.agents.model.AgentRequest;

import java.util.Map;

public class DefaultAgentOrchestrator implements AgentOrchestrator {

    private final AgentRegistry agentRegistry;

    public DefaultAgentOrchestrator(AgentRegistry agentRegistry) {
        this.agentRegistry = agentRegistry;
    }

    @Override
    public Object handle(AgentRequest request) {
        DomainAgent agent = agentRegistry.resolve(request);

        AgentContext context = new AgentContext(
                request.schoolId(),
                request.userId(),
                request.correlationId(),
                Map.of()
        );

        return agent.execute(request, context);
    }
}
