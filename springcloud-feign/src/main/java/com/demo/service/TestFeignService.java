package com.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "MEMBER")
public interface TestFeignService {

    @RequestMapping(value = "/memberService/testRest", method = RequestMethod.GET)
    String testRest();

    @RequestMapping(value = "/memberService/testResponseBase2", method = RequestMethod.GET)
    String testResponseBase2(@RequestParam(value = "msg") String name);
}
