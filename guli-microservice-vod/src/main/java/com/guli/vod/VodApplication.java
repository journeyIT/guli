package com.guli.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: journey
 * @Date: 2020/2/29
 * @Time: 10:10 下午
 * @Description:
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 排除jdbc
@ComponentScan(basePackages = {"com.guli.vod","com.guli.common"})
public class VodApplication {
    public static void main(String[] args) {
        SpringApplication.run(VodApplication.class, args);
    }
}
