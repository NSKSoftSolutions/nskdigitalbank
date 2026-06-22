package com.nsk.digitalbank.loansservices.loanservices.controller;

import com.nsk.digitalbank.loansservices.loanservices.dtos.LoanDTO;
import com.nsk.digitalbank.loansservices.loanservices.entites.Loan;
import com.nsk.digitalbank.loansservices.loanservices.records.LoanProperties;
import com.nsk.digitalbank.loansservices.loanservices.services.ILoanServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/digitalbank/loans")
@Tag(name="LOANSERVICES",description = "This API is responsible for handling all loans related operations such as creating and getting loan details")
public class LoanController {

    @Autowired
    private ILoanServices loanServices;
    @Autowired
    private LoanProperties loanProperties;
    @GetMapping("/loans")
    @Operation(summary = "This is Dummy Loans Service",description = "Its just a Dummy Service to check the Loans Service is working fine or not")
    public String loans(){
        return "Loans Services API is working fine";
    }
    @PostMapping("/apply-loan")
    @Operation(summary = "Apply for a new loan", description = "This API is responsible for applying for a new loan by providing the necessary details such as loan amount, tenure, etc.")
    @ApiResponses(value = {
        @ApiResponse(description = "Loan applied successfully", responseCode = "200"),
        @ApiResponse(description = "Invalid loan details provided", responseCode = "400"),
        @ApiResponse(description = "Internal server error", responseCode = "500")
    })
    public ResponseEntity<String> applyForLoan(@RequestBody Loan loan){
        return ResponseEntity.ok(loanServices.applyForLoan(loan));
    }
    @GetMapping("/fetch_loan")
    @Operation(summary = "Fetching Loan using LoanAccount Number",description = "This API is responsible for fetching the loan details by providing the loan account number")
    @ApiResponses(
            value = {
                    @ApiResponse(description = "Loan details fetched successfully", responseCode = "200"),
                    @ApiResponse(description = "Loan not found with the given loan account number", responseCode = "404"),
                    @ApiResponse(description = "Internal server error", responseCode = "500")
    })
    public ResponseEntity<LoanDTO> getLoanByLoanNumber(@RequestParam String loanAccountNumber){
        return ResponseEntity.ok(loanServices.getLoan(loanAccountNumber));
    }
    @GetMapping("/loan_details")
    public ResponseEntity<LoanProperties> loanDetails() {
        System.out.println("Loan Properties: " + loanProperties);

        return ResponseEntity.ok(loanProperties);
    }

}
