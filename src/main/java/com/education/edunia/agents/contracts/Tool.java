package com.education.edunia.agents.contracts;

import com.education.edunia.agents.orchestration.AgentContext;

public interface Tool<I, O> {
    String key();

    O execute(I input, AgentContext context);
}
