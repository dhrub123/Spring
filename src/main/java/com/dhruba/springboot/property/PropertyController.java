package com.dhruba.springboot.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

//	@Autowired
//	RestTemplate restTemplate;

	@Autowired
	PropertyLoadingService propertyLoadingService;

	@Value("${spring.application.name}")
	private String name;

	@RequestMapping(value = "/properties")
	public void loadProperties() {
		propertyLoadingService.loadProperties();
	}

	@RequestMapping(value = "/")
	public String greeting() {
		return name;
	}
}
