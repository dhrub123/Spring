package com.dhruba.springboot.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class SpringBootTutorialHealthCheckInfo implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		//add new info
		builder
			.withDetail("project_name", "SpringBootTutorial")
			.withDetail("team", "Dhruba_Dev")
			.withDetail("contact", "Dhruba")
				.build();

	}

}
