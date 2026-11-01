# Agent Tools Matrix

This matrix defines which tools each agent can use.

| Agent | Tool | Access | Purpose | Constraints |
|---|---|---|---|---|
| ArchitectureAgent | ModuleBoundaryCheckTool | Read | Validate package/module boundaries | No file writes |
| ArchitectureAgent | DependencyPolicyTool | Read | Enforce dependency rules | No network calls |
| ArchitectureAgent | PackageConventionsTool | Read | Check naming/package conventions | No file writes |
| CodeQualityAgent | LintTool | Read | Static analysis and style checks | No auto-fix without review |
| CodeQualityAgent | TestScaffoldTool | Write | Generate test skeletons | Only in `src/test` |
| CodeQualityAgent | CoverageTool | Read | Coverage reporting | Must not alter code |
| DevOpsAgent | PipelineTemplateTool | Write | CI pipeline templates | Changes limited to CI files |
| DevOpsAgent | DockerTemplateTool | Write | Containerization templates | Changes limited to Docker files |
| DevOpsAgent | EnvCheckTool | Read | Validate required env vars | No secret values in logs |

## Global Limits

- Max tool calls per request: `5`
- Default tool timeout: `15s`
- Execution must include: `schoolId`, `userId`, `correlationId`
- All tool invocations must be logged with correlation metadata
