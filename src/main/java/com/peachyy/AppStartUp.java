package com.peachyy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.peachyy")
public class AppStartUp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AppStartUp.class)
                .run(args);
    }
}
