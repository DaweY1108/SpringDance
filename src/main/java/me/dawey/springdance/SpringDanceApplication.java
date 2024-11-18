package me.dawey.springdance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringDanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDanceApplication.class, args);
    }

}
