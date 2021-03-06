package com.demo.constants;

public interface Constants {

	// 响应code
	String HTTP_RES_CODE_NAME = "code";
	// 响应msg
	String HTTP_RES_CODE_MSG = "msg";
	// 响应data
	String HTTP_RES_CODE_DATA = "data";
	// 响应请求成功
	String HTTP_RES_CODE_200_VALUE = "success";
	// 系统错误
	String HTTP_RES_CODE_500_VALUE = "fial";
	// 响应请求成功code
	Integer HTTP_RES_CODE_200 = 200;
	// 系统错误
	Integer HTTP_RES_CODE_500 = 500;

	// SMS MAIL类型
	String SMS_MAIL = "sms_mail";

	// 会员生成token
	String MEMBER_TOKEN ="MEMBER_TOKEN";
	// 会员超时时间
	Long MEMBER_TOKEN_TIMEOUT =(long) (60*60*24*80);

}
