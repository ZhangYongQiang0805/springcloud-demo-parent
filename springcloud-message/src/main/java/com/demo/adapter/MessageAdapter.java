package com.demo.adapter;

import com.alibaba.fastjson.JSONObject;

//统一发送信息接口
public interface MessageAdapter {
    public void sendMsg(JSONObject body);
}
