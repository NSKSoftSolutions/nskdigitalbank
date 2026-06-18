package com.nsk.digital.nskdigibank.accountservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name="com.nsk.digital.nskdigibankaccount.records.Accounts",description = "This DTO is responsible for handling all the account related details " +
        "such as account number, account type, branch name, etc.")
public class AccountsDTO {

    @Schema(description = "Account Number should be 10 digits", example = "1234567890")
    @NotEmpty(message="Account Number Should be Empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Account Number should be 10 digits")
    private Long accountNumber;
    @Schema(description="AccountType Should be (Savings, Current, Fixed ..etc)",example = "Saving")
    @NotEmpty(message="Account Type Should be Empty")
    @Size(min=6,max=20,message = "Account Type should be between 6 and 20 characters")
    private String accountType;
    @Schema(description = "Enter Branch Name", example = "NSK Bank Main Branch")
    @NotEmpty(message="Branch Name Should be Empty")
    @Size(min = 10, max = 100, message = "Branch Name should be between 10 and 100 characters")
    private String branchAddress;
}
