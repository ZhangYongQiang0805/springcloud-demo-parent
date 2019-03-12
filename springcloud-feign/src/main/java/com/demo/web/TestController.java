package com.demo.web;

import com.demo.service.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TestFeignService testFeignService;

    @RequestMapping(value = "/testRest", method = RequestMethod.GET)
    public String testRest() {
        return testFeignService.testRest();
    }

    @RequestMapping(value = "/testResponseBase2", method = RequestMethod.GET)
    public String testResponseBase2(@RequestParam String name) {
        return testFeignService.testResponseBase2(name);
    }
}
