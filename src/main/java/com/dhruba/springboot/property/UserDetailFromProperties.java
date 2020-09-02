package com.dhruba.springboot.property;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * 
 * @author dhruba
 * Add @Configuration
   @ConfigurationProperties(prefix = "demoservice.user.details")
   
   where property file is like 
   demoservice:
   user:
     details:
       role: user
       credential:
         dhruba: magora
         dayita: aroit
         mommy: daddy
 */
@Configuration
@ConfigurationProperties(prefix = "demoservice.user.details")
@Validated
public class UserDetailFromProperties {

	@NonNull
	private String role;
	
	@NonNull
	private Map<String, String> credential;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Map<String, String> getCredential() {
		return credential;
	}

	public void setCredential(Map<String, String> credential) {
		this.credential = credential;
	}

	@Override
	public String toString() {
		return "UserDetailFromProperties [role=" + role + ", credential=" + credential + "]";
	}

}
