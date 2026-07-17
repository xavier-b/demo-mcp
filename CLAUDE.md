# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build
mvn clean package

# Run
mvn spring-boot:run

# Run tests
mvn test

# Run a single test class
mvn test -Dtest=DemoMcpApplicationTests

# Run a single test method
mvn test -Dtest=DemoMcpApplicationTests#contextLoads
```

## Architecture

This is a **Spring AI MCP (Model Context Protocol) server** — a Spring Boot 4.x application that exposes tools to AI clients over HTTP using the MCP protocol.

**Key stack:**
- Java 21, Spring Boot 4.0.6
- `spring-ai-starter-mcp-server` + `spring-ai-starter-mcp-server-webmvc` (Spring AI 2.0.0-M6)

**How MCP tools are registered:**
- Any `@Service` bean with methods annotated `@McpTool` is automatically discovered and exposed as an MCP tool.
- `@McpToolParam` annotates parameters to provide descriptions and required flags to clients.
- `WeatherService` is the only tool provider currently; add new services following the same pattern to extend the server's capabilities.

The server runs on the default Spring Boot port (8080) with no authentication. The MCP endpoint is provided by the WebMVC starter at the standard MCP HTTP path.