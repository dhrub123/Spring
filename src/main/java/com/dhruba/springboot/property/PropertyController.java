package com.dhruba.springboot.property;

import java.util.HashMap;
import java.util.Map;

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
	
	@Value("app.version")
	private String version;
	
	@RequestMapping(value = "/properties")
	public void loadProperties() {
		propertyLoadingService.loadProperties();
	}

	@RequestMapping(value = "/")
	public Map<String,String>  greeting() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("app-name", name);
		map.put("app-version", version);
		return map;
	}
}
