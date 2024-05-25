package com.example.EmployeeMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

@SpringBootApplication

public class EmployeeMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMasterApplication.class, args);
	}

}
