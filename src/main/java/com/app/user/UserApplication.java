package com.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication implements CommandLineRunner {

    @Autowired
    RestTemplate restTemplate;

    @Value("${ping-server}")
    private String server;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //ResponseEntity<String> response = restTemplate.getForEntity("http://users/api/v1/dummies/", String.class);
        //System.out.println(response.getBody());
        System.out.println(server);
    }
}
