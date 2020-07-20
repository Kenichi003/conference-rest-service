package com.kentech.conferencedemo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder<?> builder = DataSourceBuilder.create();
		builder.url("jdbc:mysql://localhost:3306/conference_app?useSSL=false");//this overrides the spring.datasource.url property in the application.properties file
		builder.username("root");
		builder.password("root");
		System.out.println("Persistence configuration flag");
		return builder.build();
	}

}
