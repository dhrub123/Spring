package com.dhruba.springboot.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
	
	/**
	 * Spring will look if there is any other datasource in the context
	 * and if there is , it will simply replace the datasource with the following one
	 */
	
	/**
	 * 
	 * Comment out if deploying in heroku
	 */
	/*
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder builder = DataSourceBuilder.create();
		builder.url("jdbc:postgresql://localhost:5432/conference_app");
		builder.username("postgres");
		builder.password("Welcome");
		return builder.build();
	}*/
}
