package com.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.demo.base.BaseController;
import com.demo.base.BaseRedisService;
import com.demo.base.ResponseBase;
import com.demo.dao.UserDao;
import com.demo.model.UserEntity;
import com.demo.mq.RegisterMailboxProducer;
import com.demo.service.MemberService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberServiceImpl extends BaseController implements MemberService {

    @Autowired
    private BaseRedisService baseRedisService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RegisterMailboxProducer registerMailboxProducer;
    @Value("${messages.queue}")
    private String MESSAGES_QUEUE;

    @Override
    public Map<String, Object> testRest() {
        Map<String, Object> result = new HashMap<>();
        result.put("errorCode", "200");
        result.put("errorMsg", "success");
        return result;
    }

    @Override
    public ResponseBase testResponseBase() {
        return setResultSuccess();
    }

    @Override
    public ResponseBase testResponseBase2(String msg) {
        return setResultSuccess(msg);
    }

    @Override
    public ResponseBase setTestRedis(String key, String value) {
        baseRedisService.setString(key, value);
        return setResultSuccess();
    }

    @Override
    public ResponseBase getRedis(String key) {
        String value = baseRedisService.getString(key);
        return setResultSuccess(value);
    }

    @Override
    public ResponseBase findUser(Long userId) {
        UserEntity user = userDao.findByID(userId);
        if (user == null) {
            return setResultError("没查找到该用户信息");
        }
        return setResultSuccess(user.toString());
    }

    @Override
    public ResponseBase register(@RequestBody UserEntity user) {
        int i = userDao.insertUser(user);
        if (i <= 0) {
            return setResultError("注册失败!");
        }
        // 采用MQ异步发送邮件
        String email = user.getEmail();
        String messAageJson = message(email);
        sendMsg(messAageJson);
        return setResultSuccess("注册成功!");
    }

    private String message(String mail) {
        JSONObject root = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("interfaceType", "sms_mail");
        JSONObject content = new JSONObject();
        content.put("mail", mail);
        root.put("header", header);
        root.put("content", content);
        return root.toJSONString();
    }

    private void sendMsg(String json) {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue(MESSAGES_QUEUE);
        registerMailboxProducer.sendMsg(activeMQQueue, json);
    }
}
