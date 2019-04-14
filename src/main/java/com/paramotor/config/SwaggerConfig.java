package com.paramotor.config;


import com.google.common.base.Predicates;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("!prod")
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Paramotor API")
                .description("API documentation for Paramotor")
                .contact(new Contact("Roman Dobrynin", "http://www.webdeveloper.ee", "roman.dobrynin@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://paramotorflight.com")
                .version("2.0")
                .build();
    }

}