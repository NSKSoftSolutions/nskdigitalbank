package com.nsk.digitalbank.loansservices.loanservices.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nsk.digitalbank.loansservices.loanservices.enums.LoanType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Data
public class LoanDTO{
    private long loanAccountNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LoanType loanType;
    private String loanAmount;
    private String tenureInMoths;
    private String interestRate;
    private LocalTime createdTime;
    private LocalDate createdDate;
    private LocalTime updatedTime;
    private LocalDate updatedDate;

}
