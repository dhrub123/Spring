package com.dhruba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController

public class DemoApplication{
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${spring.application.name}")
	private String name;
	
	public static void main(String[] args) {
		logger.info("This is info");
		logger.warn("This is a warning");
		logger.error("This is an error");
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@RequestMapping(value = "/")
	public String greeting() {
		return name;
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
