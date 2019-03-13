package com.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//开启刷新
public class ConfigService {

    @Value("${info}")
    private String values;

    @RequestMapping("/")
    public String getValue() {
        return "从Github仓库中获取的信息：【" + values + "】";
    }
}
