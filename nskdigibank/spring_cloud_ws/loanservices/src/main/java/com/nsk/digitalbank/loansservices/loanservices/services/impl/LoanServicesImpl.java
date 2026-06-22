package com.nsk.digitalbank.loansservices.loanservices.services.impl;

import com.nsk.digitalbank.loansservices.loanservices.dtos.LoanDTO;
import com.nsk.digitalbank.loansservices.loanservices.entites.Loan;
import com.nsk.digitalbank.loansservices.loanservices.mappers.LoanMappers;
import com.nsk.digitalbank.loansservices.loanservices.repository.LoanRepository;
import com.nsk.digitalbank.loansservices.loanservices.services.ILoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Random;

@Service
public class LoanServicesImpl implements ILoanServices {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LoanMappers loanMappers;
    @Override
    public String applyForLoan(Loan loan) {
        loan.setCreatedDate(LocalDate.now());
        loan.setCreatedTime(LocalTime.now());
        long randomNumber = 1000000000L + (long)(new Random().nextDouble() * 9000000000L);
        loan.setLoanAccountNumber(randomNumber);
        Loan loans=loanRepository.save(loan);
        LoanDTO loanDTO=loanMappers.convertLoanToLoanDto(loans);
        return "Loan applied successfully with loan account number: "+loanDTO.getLoanAccountNumber();
    }

    @Override
    public LoanDTO getLoan(String loanAccountNumber) {
        LoanDTO loanDTO=null;
        Optional<Loan> loan=loanRepository.findByLoanAccountNumber(Long.parseLong(loanAccountNumber));
        if (loan.isPresent()){
            loanDTO=loanMappers.convertLoanToLoanDto(loan.get());
        }
      return loanDTO;
    }
}
