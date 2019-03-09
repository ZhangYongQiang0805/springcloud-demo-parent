package com.demo.service.impl;

import com.demo.base.BaseController;
import com.demo.base.BaseRedisService;
import com.demo.base.ResponseBase;
import com.demo.dao.UserDao;
import com.demo.model.UserEntity;
import com.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return setResultSuccess("注册成功!");
    }
}
