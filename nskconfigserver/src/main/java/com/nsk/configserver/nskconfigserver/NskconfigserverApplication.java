package com.nsk.configserver.nskconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class NskconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(NskconfigserverApplication.class, args);
	}

}
