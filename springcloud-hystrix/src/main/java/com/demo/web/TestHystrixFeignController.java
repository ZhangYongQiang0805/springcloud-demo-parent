package com.demo.web;

import com.demo.service.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHystrixFeignController {

    @Autowired
    TestFeignService testFeignService;

    @RequestMapping(value = "/testRestFeign", method = RequestMethod.GET)
    public String testRest() {
        return testFeignService.testRest();
    }

    @RequestMapping(value = "/testRestFeign2", method = RequestMethod.GET)
    public String testRest2(@Param(value = "name") String name) {
        return testFeignService.testResponseBase2(name);
    }
}
