package com.book.store;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {
		"com.book.store.controllers",
		"com.book.store.config",
		"com.book.store.dao",
		"com.book.store.dto",
		"com.book.store.enums",
		"com.book.store.exceptions",
		"com.book.store.models",
		"com.book.store.services",
		"com.book.store.utils"	
})
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
		System.out.println("Book Service is running");
	}
	
	@Bean
	public RestTemplate restTemplateBean() {
	        return new RestTemplate();
	}

}
