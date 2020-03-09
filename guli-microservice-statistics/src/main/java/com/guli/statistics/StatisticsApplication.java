package com.guli.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: journey
 * @Date: 2020/2/24
 * @Time: 6:08 下午
 * @Description:
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.guli.statistics","com.guli.common"})
@EnableEurekaClient
@EnableFeignClients
public class StatisticsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatisticsApplication.class, args);
    }
}
