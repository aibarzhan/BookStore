package com.example.bookstore.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        servers = {
                @Server(
                        description = "book service",
                        url = "http://localhost:8080"
                )
        }
)
public class SwaggerConfig {
}
