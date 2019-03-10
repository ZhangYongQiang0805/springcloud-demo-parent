package com.demo.utils;

import com.demo.constants.Constants;

import java.util.UUID;

public class TokenUtils {
    public static String getToken() {
        return Constants.MEMBER_TOKEN + UUID.randomUUID();
    }
}
