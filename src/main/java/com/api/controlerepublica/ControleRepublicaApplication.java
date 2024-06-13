package com.api.controlerepublica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"models"})
public class ControleRepublicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleRepublicaApplication.class, args);
    }

}
