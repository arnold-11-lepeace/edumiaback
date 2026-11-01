package com.education.edunia.agents.api;


import com.education.edunia.agents.model.AgentRequest;
import com.education.edunia.agents.model.AgentResponse;
import com.education.edunia.agents.orchestration.AgentOrchestrator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    private final AgentOrchestrator agentOrchestrator1;

    public AgentController(AgentOrchestrator agentOrchestrator) {
        this.agentOrchestrator1 = agentOrchestrator;
    }

    @PostMapping("/execute")
    public ResponseEntity<AgentResponse> execute(@RequestBody AgentRequest request) {
        Object result = agentOrchestrator1.handle(request);

        if (!(result instanceof AgentResponse response)) {
            throw new IllegalStateException("AgentOrchestrator must return AgentResponse");
        }

        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
