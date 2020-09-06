package com.dhruba.springboot.documentation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class SpringFoxConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}
	
	//create api metadata that goes to top of generated page
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("SpringBootTutorial API")
				.version("1.0")
				.description("Api for Spring Boot Tutorial")
				.contact(new Contact("Dhruba Nag", "http://dhruba.springtutorial.com", "dhruba.nag@springtutorial.com"))
				.license("Apache License V2")
				.build();
	}

}
