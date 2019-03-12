package com.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestHystrixRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String testRestRibbon() {
        String url = "http://MEMBER/memberService/testRest";
        return restTemplate.getForObject(url, String.class);
    }

    public String hiError() {
        return "hi,sorry,error!";
    }

}
