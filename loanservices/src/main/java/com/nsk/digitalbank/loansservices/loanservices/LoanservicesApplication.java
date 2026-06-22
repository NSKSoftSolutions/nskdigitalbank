package com.nsk.digitalbank.loansservices.loanservices;

import com.nsk.digitalbank.loansservices.loanservices.dtos.LoanDTO;
import com.nsk.digitalbank.loansservices.loanservices.records.LoanProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(description = "Loan Services API", title = "Loan Services API", version = "1.0"))
@EnableConfigurationProperties(value = LoanProperties.class)
public class LoanservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanservicesApplication.class, args);
	}

}
