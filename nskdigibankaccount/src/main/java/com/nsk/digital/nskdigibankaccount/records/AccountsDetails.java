package com.nsk.digital.nskdigibankaccount.records;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "accounts")
public record AccountsDetails(String accountNumber, String accountType, double balance) {
}
