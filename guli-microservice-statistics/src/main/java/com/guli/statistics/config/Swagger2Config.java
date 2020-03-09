package com.guli.statistics.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author helen
 * @since 2019/6/24
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket adminApiConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("adminApi")
				.apiInfo(adminApiInfo())
				.select()
				.paths(Predicates.and(PathSelectors.regex("/admin/.*")))
				.build();
	}

	@Bean
	public Docket webApiConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("webApi")
				.apiInfo(webApiInfo())
				.select()
				.paths(Predicates.not(PathSelectors.regex("/admin/.*")))
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build();
	}

	private ApiInfo adminApiInfo(){

		return new ApiInfoBuilder()
				.title("通用服务")
				.description("简单优雅的restfun风格，https://gitee.com/journeyIT")
				.termsOfServiceUrl("https://gitee.com/journeyIT")
				.version("1.0")
				.contact(new Contact("Journey", "https://gitee.com/journeyIT", "892118510@qq.com"))
				.build();
	}

	private ApiInfo webApiInfo(){

		return new ApiInfoBuilder()
				.title("通用服务")
				.description("简单优雅的restfun风格，https://gitee.com/journeyIT")
				.termsOfServiceUrl("https://gitee.com/journeyIT")
				.version("1.0")
				.contact(new Contact("Journey", "https://gitee.com/journeyIT", "892118510@qq.com"))
				.build();
	}
}
