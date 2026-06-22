package com.nsk.digitalbank.loansservices.loanservices.services;

import com.nsk.digitalbank.loansservices.loanservices.dtos.LoanDTO;
import com.nsk.digitalbank.loansservices.loanservices.entites.Loan;

public interface ILoanServices {

    public String applyForLoan(Loan loan);

    public LoanDTO getLoan(String loanAccountNumber);
}
