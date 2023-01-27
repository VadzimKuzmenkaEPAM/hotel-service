package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.Ordered;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.demo.model")
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}