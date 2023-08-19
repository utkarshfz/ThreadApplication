package com.application.virtualthread.controller;

import com.application.virtualthread.service.NonCPUBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread-application")
public class AppController {

    @Autowired
    private NonCPUBoundService nonCPUBoundService;

    @GetMapping("/run")
    public ResponseEntity<String> invokeVirtualThreadApplication() {
        nonCPUBoundService.executeNonCPUBoundTask();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
