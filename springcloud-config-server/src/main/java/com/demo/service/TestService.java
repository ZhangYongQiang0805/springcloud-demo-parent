package com.demo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

    @RequestMapping("/")
    public String getBlogInfo() {
        return "hello";
    }
}
