package com.education.edunia.agents.quality;

import com.education.edunia.agents.contracts.DomainAgent;
import com.education.edunia.agents.model.AgentRequest;
import com.education.edunia.agents.model.AgentResponse;
import com.education.edunia.agents.orchestration.AgentContext;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CodeQualityAgent implements DomainAgent {

    public static final String AGENT_KEY = "code-quality";

    @Override
    public String name() {
        return AGENT_KEY;
    }

    @Override
    public boolean supports(AgentRequest request) {
        if (request == null || request.agentKey() == null) {
            return false;
        }
        return AGENT_KEY.equalsIgnoreCase(request.agentKey().trim());
    }

    @Override
    public Object execute(AgentRequest request, AgentContext context) {
        String task = request.task() == null ? "" : request.task().toLowerCase(Locale.ROOT);

        if (task.contains("test") || task.contains("integration")) {
            return new AgentResponse(
                    name(),
                    "Priorite qualite: ajoute des tests d'integration pour payments et audit.",
                    List.of(),
                    Map.of("nextStep", "add-integration-tests")
            );
        }

        if (task.contains("validation") || task.contains("dto")) {
            return new AgentResponse(
                    name(),
                    "Ajoute @Valid sur les requetes et centralise les erreurs avec un handler global.",
                    List.of(),
                    Map.of("nextStep", "harden-input-validation")
            );
        }

        return new AgentResponse(
                name(),
                "Je peux verifier: conventions, validations, tests, et robustesse des endpoints.",
                List.of(),
                Map.of("checklist", List.of("lint", "tests", "validation", "error-handling"))
        );
    }
}
