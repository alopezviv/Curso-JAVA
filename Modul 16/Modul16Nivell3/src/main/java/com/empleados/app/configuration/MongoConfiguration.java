package com.empleados.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.empleados.app.beans.UUIDListener;

@Configuration
@EnableMongoAuditing
public class MongoConfiguration {
	
    @Bean
    public UUIDListener generateUUIDListener() {
        return new UUIDListener();
    }

	    
	
}
