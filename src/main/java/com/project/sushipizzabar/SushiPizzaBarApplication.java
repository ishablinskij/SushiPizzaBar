package com.project.sushipizzabar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class SushiPizzaBarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SushiPizzaBarApplication.class, args);
    }
}
