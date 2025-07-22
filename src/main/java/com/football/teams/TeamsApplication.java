package com.football.teams;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit              
@SpringBootApplication
public class TeamsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamsApplication.class, args);
    }
}