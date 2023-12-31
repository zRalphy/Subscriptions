package org.openapitools.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

	@Bean(name = "org.openapitools.configuration.SpringDocConfiguration.apiInfo")
	OpenAPI apiInfo() {
		return new OpenAPI()
				.info(
						new Info()
								.title("Subscription API")
								.description("Application to manage subscriptions")
								.version("1.0.0")
				)
				.components(
						new Components()
								.addSecuritySchemes("bearerAuth", new SecurityScheme()
										.type(SecurityScheme.Type.HTTP)
										.scheme("bearer")
										.bearerFormat("JWT")
								)
				);
	}
}