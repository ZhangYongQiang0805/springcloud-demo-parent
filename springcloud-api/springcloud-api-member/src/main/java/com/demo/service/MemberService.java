package com.demo.service;

import com.demo.base.ResponseBase;
import com.demo.model.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/memberService")
public interface MemberService {

    @RequestMapping("/testRest")
    public Map<String, Object> testRest();

    @RequestMapping("/testResponseBase")
    public ResponseBase testResponseBase();

    @RequestMapping("/testResponseBase2")
    public ResponseBase testResponseBase2(String msg);

    /**
     * 设置redis的值
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/setTestRedis")
    public ResponseBase setTestRedis(String key, String value);

    /**
     * 获取Redis中key的值
     * @param key
     * @return
     */
    @RequestMapping("/getRedis")
    public ResponseBase getRedis(String key);

    /**
     * 数据库查询用户，根据用户id
     * @param userId
     * @return
     */
    @RequestMapping("/findUser")
    public ResponseBase findUser(Long userId);

    /**
     * 注册用户，并保存到数据库中
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public ResponseBase register(@RequestBody UserEntity user);
}
