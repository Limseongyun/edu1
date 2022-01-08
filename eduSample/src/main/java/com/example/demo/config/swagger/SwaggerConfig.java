package com.example.demo.config.swagger;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("EDU Sample")
				.description("EDU Sample")
				.version("v0.0.1"));
	}
	@Bean
	public GroupedOpenApi api1() {
		return GroupedOpenApi.builder()
				.group("sample")
				.packagesToScan("com.example.demo.api")
				.build();
	}

}