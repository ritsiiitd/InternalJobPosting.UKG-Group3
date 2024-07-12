package com.ukgG3.JobPosting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JobPosting {
	public static void main(String[] args) {
		SpringApplication.run(JobPosting.class, args);
	}
}
