package com.example.ebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//exclude = { SecurityAutoConfiguration.class }
@SpringBootApplication()
public class EbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbookApplication.class, args);
    }

}
