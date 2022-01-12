package com.example.demo.config.swagger;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.components(
					new Components()
						.addSecuritySchemes("Token!", new SecurityScheme()
															.type(SecurityScheme.Type.HTTP)
															.in(SecurityScheme.In.HEADER)
															.scheme("Bearer")
															.name("Authorization")
															.bearerFormat("JWT"))
				)
				.addSecurityItem(new SecurityRequirement().addList("Token!"))
				.info(new Info().title("EDU Sample")
				.description("EDU Sample")
				.version("v0.0.1"));
	}
	@Bean
	public GroupedOpenApi api1() {
		return GroupedOpenApi.builder()
				.group("sample")
				.packagesToScan("com.example.demo.mvc.restcontroller")
				.build();
	}

}