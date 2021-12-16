package com.example.prova.quartaprova.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api () {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.prova.quartaprova"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo () {
        return new ApiInfoBuilder()
                .title("PROVA - Estoque")
                .description("Sistema de estoque de produtos")
                .version("1.0.0")
                .build();
    }
}