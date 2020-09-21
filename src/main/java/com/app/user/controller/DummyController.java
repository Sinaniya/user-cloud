package com.app.user.controller;

import com.app.user.services.misc.IdUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dummies")
@RefreshScope
public class DummyController {

    @Value("${eureka.instance.instance-id}")
    String instanceId;

    @Value("${ping-server}")
    String pingServer;

    @GetMapping("/")
    public ResponseEntity test() {
        return ResponseEntity.ok("dummies " + instanceId);
    }

    @GetMapping("/pings")
    public ResponseEntity pings() {
        return ResponseEntity.ok(pingServer);
    }

    @GetMapping("/ids")
    public ResponseEntity ids() {
        return ResponseEntity.ok(IdUtil.getId());
    }
}
