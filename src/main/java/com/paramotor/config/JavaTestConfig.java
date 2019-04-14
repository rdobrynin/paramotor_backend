package com.paramotor.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration

public class JavaTestConfig {

    @PostConstruct
    public void test() {
        System.out.println("========= THIS IS TESTING ENVIRONMENT ========= ");
    }
}
