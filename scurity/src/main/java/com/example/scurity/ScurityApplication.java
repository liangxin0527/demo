package com.example.scurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableWebSecurity
public class ScurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScurityApplication.class, args);
    }

}
