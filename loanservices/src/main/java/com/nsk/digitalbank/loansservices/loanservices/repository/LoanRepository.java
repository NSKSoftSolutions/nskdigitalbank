package com.nsk.digitalbank.loansservices.loanservices.repository;

import com.nsk.digitalbank.loansservices.loanservices.dtos.LoanDTO;
import com.nsk.digitalbank.loansservices.loanservices.entites.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
    Optional<Loan> findByLoanAccountNumber(long loanAccountNumber);
}
