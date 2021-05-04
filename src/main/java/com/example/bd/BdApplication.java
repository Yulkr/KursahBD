package com.example.bd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/**
 * Класс для запуска сервера
 *
 */
@SpringBootApplication
@EnableJpaAuditing
public class BdApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdApplication.class, args);
    }

}
