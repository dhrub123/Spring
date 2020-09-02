package com.dhruba.springboot.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertyLoadingServiceImpl implements PropertyLoadingService {
	
	@Autowired
	UserDetailFromProperties userDetailFromProperties;
	
	/* (non-Javadoc)
	 * @see com.dhruba.springboot.property.PropertyLoadingService#loadProperties()
	 */
	@Override
	public String loadProperties() {
		userDetailFromProperties.getRole();
		userDetailFromProperties.getCredential().entrySet().stream().forEach(entry -> {
			System.out.println("User = " + entry.getKey() + " Password = " + entry.getValue());
		});
		return userDetailFromProperties.toString();
	}

}
