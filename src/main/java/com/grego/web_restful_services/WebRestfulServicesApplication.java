package com.grego.web_restful_services;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebRestfulServicesApplication {

	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(WebRestfulServicesApplication.class, args);
	}

}
