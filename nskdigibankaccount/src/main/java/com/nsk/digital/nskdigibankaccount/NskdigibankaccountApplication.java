package com.nsk.digital.nskdigibankaccount;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="NSKDIGITAL BANK ONLINE SERVICES",description="He You will perform Online Money Transfer without adding the Benficary Details",version="1.0",
		           contact = @Contact(name = "N Sajjad Ali khan",email="sajjadalikjhan.navab@gmail.com",url="http://localhost:2026/nskonlinebankingservices/")
		,license=@License(name ="NSK BANK, AP,INDIA",url="http://localhost:2026/nskonlinebankingservices/"))
		,externalDocs = @ExternalDocumentation(url="http://localhost:2026/nskonlinebankingservices/",description = "NSKDIGITAL BANK ONLINE SERVICES"))
public class NskdigibankaccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(NskdigibankaccountApplication.class, args);
	}

}
