package com.paramotor.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class JavaProdConfig {

    @PostConstruct
    public void test() {
        System.out.println("========= THIS IS PRODUCTION ENVIRONMENT ========= ");
    }
}
