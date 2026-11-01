package com.education.edunia.agents.orchestration;

import com.education.edunia.agents.business.TuitionFeatureAgent;
import com.education.edunia.agents.contracts.DomainAgent;
import com.education.edunia.agents.model.AgentRequest;
import com.education.edunia.agents.quality.CodeQualityAgent;

import java.util.List;

public class DefaultAgentRegistry implements AgentRegistry {

    private final List<DomainAgent> agents;

    public DefaultAgentRegistry() {
        this.agents = List.of(
                new TuitionFeatureAgent(),
                new CodeQualityAgent()
        );
    }

    @Override
    public DomainAgent resolve(AgentRequest request) {
        return agents.stream()
                .filter(agent -> agent.supports(request))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No agent found for key: " + request.agentKey()));
    }
}
