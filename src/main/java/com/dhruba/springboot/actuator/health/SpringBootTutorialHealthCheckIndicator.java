package com.dhruba.springboot.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class SpringBootTutorialHealthCheckIndicator implements HealthIndicator {

	@Override
	public Health health() {
		
		/* This will show health status as down if runtime memory goes below 100 MB 
		boolean invalid = Runtime.getRuntime().maxMemory() < (100 * 1024 * 1024);
		Status status = invalid ? Status.DOWN : Status.UP;
		return Health.status(status).build(); */
		
		//Default
		return Health.up()
				//This can be used to include details
				.withDetail("response_code", "200")
				.withDetail("response_message", "All is Well")
					.build();
		
		//Can do conditional check and return status as well
		//For down status - Health.down().build
		
		
	}

}
