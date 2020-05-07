package edu.miu.cs544;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "edu.miu.common, edu.miu.cs544")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
