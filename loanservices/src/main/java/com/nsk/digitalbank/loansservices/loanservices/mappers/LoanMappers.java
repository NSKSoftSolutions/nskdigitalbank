package com.nsk.digitalbank.loansservices.loanservices.mappers;

import com.nsk.digitalbank.loansservices.loanservices.dtos.LoanDTO;
import com.nsk.digitalbank.loansservices.loanservices.entites.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMappers {

    public LoanDTO convertLoanToLoanDto(Loan loan) {
        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setLoanAccountNumber(loan.getLoanAccountNumber());
        loanDTO.setLoanType(loan.getLoanType());
        loanDTO.setLoanAmount(loan.getLoanAmount());
        loanDTO.setInterestRate(loan.getInterestRate());
        loanDTO.setTenureInMoths(loan.getTenureInMoths());
        loanDTO.setCreatedTime(loan.getCreatedTime());
        loanDTO.setCreatedDate(loan.getCreatedDate());
        return loanDTO;
    }
    public Loan convertLoanDTOToLoan(LoanDTO loanDTO) {
        Loan loan = new Loan();
        loan.setLoanAccountNumber(loanDTO.getLoanAccountNumber());
        loan.setLoanType(loanDTO.getLoanType());
        loan.setLoanAmount(loanDTO.getLoanAmount());
        loan.setInterestRate(loanDTO.getInterestRate());
        return loan;
    }
}
