package com.platos.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PlatosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatosServiceApplication.class, args);
	}

}
