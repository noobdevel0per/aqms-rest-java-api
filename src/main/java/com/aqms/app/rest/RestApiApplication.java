package com.aqms.app.rest;


import com.aqms.app.rest.serviceClass.RandomDataEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@EnableScheduling
@RestController
public class RestApiApplication {
    @Autowired
    private RandomDataEndpoint rde;

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Scheduled(fixedRate = 300000)
    @GetMapping(value = "/saveData")
    public String saveData() {
        rde.randomDataGeneration();
        return "Data Saved✔";
    }

}


