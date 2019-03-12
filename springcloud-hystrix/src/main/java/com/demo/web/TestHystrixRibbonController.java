package com.demo.web;

import com.demo.service.TestHystrixRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHystrixRibbonController {

    @Autowired
    TestHystrixRibbonService testHystrixRibbonService;

    @RequestMapping(value = "/testRestRibbon", method = RequestMethod.GET)
    public String testRestRibbon() {
        return testHystrixRibbonService.testRestRibbon();
    }

}
