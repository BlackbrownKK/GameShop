package com.example.gameshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GameShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameShopApplication.class, args);
    }

}
