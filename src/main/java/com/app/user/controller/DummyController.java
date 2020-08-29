package com.app.user.controller;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dummies")
public class DummyController {

    @Value("${eureka.instance.instance-id}")
    String instanceId;

    @GetMapping("/")
    public ResponseEntity test() {
        return ResponseEntity.ok("dummies " + instanceId);
    }
}
