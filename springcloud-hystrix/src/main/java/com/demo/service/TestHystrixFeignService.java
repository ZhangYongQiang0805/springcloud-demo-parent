package com.demo.service;

import org.springframework.stereotype.Component;

@Component
public class TestHystrixFeignService implements TestFeignService {

    @Override
    public String testRest() {
        return "TestHystrixFeignService testRest error";
    }

    @Override
    public String testResponseBase2(String name) {
        return "TestHystrixFeignService testResponseBase2 error";
    }

}
