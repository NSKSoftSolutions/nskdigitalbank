package com.nsk.digitalbank.loansservices.loanservices.entites;

import com.nsk.digitalbank.loansservices.loanservices.enums.LoanType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "LOANS")
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="LOAN_ID")
    private int loanId;
    @Column(name="LOAN_ACCOUNT_NUMBER",comment = "Loan account number must be exactly 10 digits")
    private long loanAccountNumber;
    @Column(name="LOAN_TYPE")
    private LoanType loanType;
    @Column
    private String loanAmount;
    @Column(name="TENURE_IN_MONTHS")
    private String tenureInMoths;
    private String interestRate;
    private LocalTime createdTime;
    private LocalDate createdDate;
    private LocalTime updatedTime;
    private LocalDate updatedDate;
}
