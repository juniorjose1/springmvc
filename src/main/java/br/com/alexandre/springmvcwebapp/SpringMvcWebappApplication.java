package br.com.alexandre.springmvcwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringMvcWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcWebappApplication.class, args);
	}

}
