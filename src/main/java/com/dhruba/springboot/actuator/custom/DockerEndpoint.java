package com.dhruba.springboot.actuator.custom;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "container")
public class DockerEndpoint {

	@ReadOperation
	public String read() {
		return "Docker Container Information";
	}

	@WriteOperation
	public void act() {
		// Do something, maybe restart docker
	}

}
