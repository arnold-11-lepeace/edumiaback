# AGENTS

This project uses specialized development agents to improve consistency, speed, and code quality.

## Core Principles

- Keep responsibilities explicit: each agent has a clear scope.
- Enforce least privilege: each agent can only call approved tools.
- Require traceability: always propagate `schoolId`, `userId`, and `correlationId`.
- Keep humans in control: agent output is reviewed before merge.
- Protect data: do not expose secrets or sensitive data in prompts/logs.

## Available Agents

### ArchitectureAgent

- Purpose: module boundaries, package conventions, dependency hygiene.
- Inputs: architecture task, target module, constraints.
- Outputs: structure proposals, refactor suggestions, ADR notes.
- Allowed tools: `ModuleBoundaryCheckTool`, `DependencyPolicyTool`, `PackageConventionsTool`.

### CodeQualityAgent

- Purpose: improve readability, reliability, and tests.
- Inputs: source files, quality goals, test expectations.
- Outputs: suggested patches, test scaffolds, quality findings.
- Allowed tools: `LintTool`, `TestScaffoldTool`, `CoverageTool`.

### DevOpsAgent

- Purpose: deployment consistency and runtime reliability.
- Inputs: environment targets, release constraints.
- Outputs: pipeline templates, Docker updates, config checklists.
- Allowed tools: `PipelineTemplateTool`, `DockerTemplateTool`, `EnvCheckTool`.

## Mandatory Execution Rules

- Validate `AgentRequest` before execution.
- Reject execution if required fields are missing.
- Limit tool calls per request (default max: 5).
- Apply timeout to each tool call.
- Log each execution with request metadata.

## Merge Policy

- No direct push to protected branches.
- Every agent-generated change goes through PR review.
- CI checks must pass before merge.
