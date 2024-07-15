package com.ukgG3.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IjpApplication {

	public static void main(String[] args) {
		SpringApplication.run(IjpApplication.class, args);
	}

}
