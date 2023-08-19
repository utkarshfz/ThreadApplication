package com.application.virtualthread.service;

import org.springframework.stereotype.Service;

@Service
public class NonCPUBoundService {
    public void executeNonCPUBoundTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
