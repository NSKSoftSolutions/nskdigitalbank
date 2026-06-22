package com.nsk.digitalbank.loansservices.loanservices.records;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@ConfigurationProperties(prefix = "loans")
public record LoanProperties(
        long loanAccountNumber,
        String loanType,
        BigDecimal loanAmount,
        int tenureInMonths,
        double interestRate
) {
}