package com.xlinyu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
public class SwaggerConfig{

	private SpringSwaggerConfig springSwaggerConfig;

	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	/**
	 * 自定义实现 customImplementation
	 * @return
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
				apiInfo()).includePatterns(".*?");
	}

	/**
	 * title
	 * description
	 * terms of serviceUrl
	 * contact email
	 * license type
	 * license url
	 * @return
	 */
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
			"Spring MVC Restful",
			"Spring MVC 简单示例，依赖于 MySQL 数据库，只有简单的登陆功能。",
			"开发者: ncc0706",
			"ncc0706@gmail.com",
			"MIT License", 
			"/LICENSE"
		);
		return apiInfo;
	}
}
