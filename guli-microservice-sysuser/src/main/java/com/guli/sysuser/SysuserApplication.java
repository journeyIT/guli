package com.guli.sysuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: journey
 * @Date: 2019-11-17
 * @Time: 01:09
 * @Description:
 */
@SpringBootApplication(exclude =  DataSourceAutoConfiguration.class)
public class SysuserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysuserApplication.class, args);
    }
}
