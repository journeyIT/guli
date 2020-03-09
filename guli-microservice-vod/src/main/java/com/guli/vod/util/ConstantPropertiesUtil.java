package com.guli.vod.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: journey
 * @Date: 2020/2/29
 * @Time: 10:10 下午
 * @Description:
 */
@Component
//@PropertySource("classpath:application.properties")
public class ConstantPropertiesUtil implements InitializingBean {

	@Value("${aliyun.vod.file.keyid}")
	private String keyId;

	@Value("${aliyun.vod.file.keysecret}")
	private String keySecret;

	public static String ACCESS_KEY_ID;
	public static String ACCESS_KEY_SECRET;

	@Override
	public void afterPropertiesSet() throws Exception {
		ACCESS_KEY_ID = keyId;
		ACCESS_KEY_SECRET = keySecret;
	}
}
