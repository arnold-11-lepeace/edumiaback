package com.education.edunia.agents.business;

import com.education.edunia.agents.contracts.DomainAgent;
import com.education.edunia.agents.model.AgentRequest;
import com.education.edunia.agents.model.AgentResponse;
import com.education.edunia.agents.model.ToolCall;
import com.education.edunia.agents.orchestration.AgentContext;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TuitionFeatureAgent implements DomainAgent {

    public static final String AGENT_KEY = "tuition-feature";
    @Override
    public String name() {
        return AGENT_KEY;
    }

    @Override
    public boolean supports(AgentRequest request) {
        if (request == null || request.agentKey() == null) {
            return false;
        }
        return AGENT_KEY.equalsIgnoreCase(request.agentKey());
    }

    @Override
    public Object execute(AgentRequest request, AgentContext context) {
        // Implement the execution logic for the TuitionFeatureAgent
        String task = request.task() == null ? "" : request.task().toLowerCase(Locale.ROOT);
        String schoolId = request.schoolId();
        if (task.contains("student") || task.contains("eleve")) {
            ToolCall call = new ToolCall(
                    "student.lookup",
                    Map.of("schoolId", schoolId, "task", request.task()),
                    "PLANNED"
            );
            return new AgentResponse(
                    name(),
                    "Je peux t'aider a creer les endpoints eleves (create/list/get) avec validation et test d'integration.",
                    List.of(call),
                    Map.of("nextStep", "implement-students-module")
            );
        }

        if (task.contains("fee") || task.contains("frais")) {
            ToolCall call = new ToolCall(
                    "fee.schedule",
                    Map.of("schoolId", schoolId, "task", request.task()),
                    "PLANNED"
            );
            return new AgentResponse(
                    name(),
                    "Je peux generer la gestion des frais (creation, statut, solde restant) avec contraintes metier.",
                    List.of(call),
                    Map.of("nextStep", "implement-billing-module")
            );
        }

        if (task.contains("payment") || task.contains("paiement")) {
            ToolCall call = new ToolCall(
                    "payment.reconciliation",
                    Map.of("schoolId", schoolId, "task", request.task()),
                    "PLANNED"
            );
            return new AgentResponse(
                    name(),
                    "Je peux creer le flux paiement + trace d'audit atomique pour la tracabilite.",
                    List.of(call),
                    Map.of("nextStep", "implement-payments-and-audit")
            );
        }
        return new AgentResponse(
                name(),
                "Precise ta demande: students, fees, payments, audit. Je peux te generer la feature pas a pas.",
                List.of(),
                Map.of("supportedDomains", List.of("students", "fees", "payments", "audit"))
        );
    }
}
