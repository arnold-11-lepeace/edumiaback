# CONTRIBUTING

This guide defines coding and collaboration standards for the Edunia backend.

## Workflow

- Create a feature branch from `main`.
- Keep commits focused and atomic.
- Open a pull request with context, scope, and validation notes.
- Request review before merge.

## Project Structure

Use package-by-feature with clear layer boundaries.

- `api`: controllers and transport DTOs
- `application`: use-cases and orchestration
- `domain`: business model and rules
- `core`: cross-cutting concerns (tenant, audit, security)
- `agents`: agent contracts, orchestration, tools

## Coding Standards

- Follow standard Java naming conventions.
- Keep classes small and focused.
- Prefer constructor injection.
- Avoid business logic in controllers.
- Validate external input at boundaries.

## Testing Expectations

- Add unit tests for business logic.
- Add integration tests for critical flows (payments, audit).
- Keep tests deterministic and isolated.
- Include regression tests for bug fixes.

## Security and Data Handling

- Never commit secrets.
- Use environment variables for credentials.
- Do not log sensitive values.
- Enforce tenant isolation using `schoolId`.

## Agent-Assisted Development

- Use agents to propose and accelerate changes.
- Keep human review mandatory.
- Ensure generated changes follow this guide.
