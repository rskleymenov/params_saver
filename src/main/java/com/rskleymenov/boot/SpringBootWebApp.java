package com.rskleymenov.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.rskleymenov.controller", "com.rskleymenov.service"})
@EntityScan(basePackages = {"com.rskleymenov.entity"})
@EnableJpaRepositories(basePackages = {"com.rskleymenov.repository"})
public class SpringBootWebApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApp.class, args);
    }
}
