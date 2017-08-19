package com.alekseysamoylov.bootsalad.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring-boot configuration
 */
@SpringBootApplication(scanBasePackages = {"com.alekseysamoylov.bootsalad.runner", "com.alekseysamoylov.bootsalad.config"})
public class SpringBootConsoleApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

}
