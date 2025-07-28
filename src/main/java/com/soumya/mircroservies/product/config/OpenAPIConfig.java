package com.soumya.mircroservies.product.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI productServiceAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Product Service API")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0"))
                        .description("API documentation for the Product Service"))
                .externalDocs(new io.swagger.v3.oas.models.ExternalDocumentation()
                        .description("Product Service Documentation")
                        .url("https://product-service.example.com/docs"));
    }
}
