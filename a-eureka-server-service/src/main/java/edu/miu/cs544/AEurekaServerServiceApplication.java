package edu.miu.cs544;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AEurekaServerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AEurekaServerServiceApplication.class, args);
	}

}
