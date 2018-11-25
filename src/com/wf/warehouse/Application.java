package com.wf.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wf.warehouse")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
