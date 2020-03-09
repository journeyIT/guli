package com.guli.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: journey
 * @Date: 2020/2/24
 * @Time: 5:45 下午
 * @Description:
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.guli.ucenter","com.guli.common"})
@EnableEurekaClient
public class UcenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication.class, args);
    }
}
