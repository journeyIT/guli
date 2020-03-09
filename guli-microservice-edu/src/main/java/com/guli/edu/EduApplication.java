package com.guli.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author helen
 * @since 2019/6/24
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.guli.edu","com.guli.common"})
@EnableEurekaClient
public class EduApplication {

	public static void main(String[] args){
		SpringApplication.run(EduApplication.class, args);
	}
}
