package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/testRest", method = RequestMethod.GET)
    public String testGetNameOfBlog() {
        String url = "http://MEMBER/memberService/testRest";
        return restTemplate.getForObject(url, String.class);
    }
}
