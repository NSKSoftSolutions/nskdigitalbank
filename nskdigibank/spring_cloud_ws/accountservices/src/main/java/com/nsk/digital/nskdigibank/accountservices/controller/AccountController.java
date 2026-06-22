package com.nsk.digital.nskdigibank.accountservices.controller;

import com.nsk.digital.nskdigibank.accountservices.constants.AccountConstants;
import com.nsk.digital.nskdigibank.accountservices.dto.AccountsDTO;
import com.nsk.digital.nskdigibank.accountservices.dto.ResponseDTO;
import com.nsk.digital.nskdigibank.accountservices.records.AccountsDetails;
import com.nsk.digital.nskdigibank.accountservices.services.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/digitalbankaccount")
@Tag(name = "ACCOUNT SERVICES", description = "This API is responsible for handling all the account related operations such as creating account, fetching details, updating details and deleting account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private Environment environment;
    @Autowired
    private AccountsDetails accountsDetails;

    @GetMapping("/greetings")
    @Operation(summary = "Greetings Message", description = "This API is responsible for providing a greetings message to the users when they access the account services")
    @ApiResponses({
            @ApiResponse(description = "Greetings message provided successfully", responseCode = AccountConstants.STATUS_201)
    })
    public String greetingsMessage() {
        return "Welcome to NSK DIgital Banking Account Services";
    }

    @PostMapping("/createAccount")
    @Operation(summary = "Create a new account", description = "This API is responsible for creating a new account by providing the necessary details such as account type, initial deposit, etc.")
    @ApiResponses({
            @ApiResponse(description = "Account created successfully", responseCode = AccountConstants.STATUS_200)
    })
    public ResponseDTO createAccount(@RequestBody AccountsDTO accountsDTO) {
        accountService.createAccount(accountsDTO);
        return new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200);
    }

    @GetMapping("/maven-home")
    public String javaHomeDirectory() {
        return environment.getProperty("MAVEN_HOME");
    }

    @GetMapping("/accounts_props")
    public ResponseEntity<AccountsDetails> accounts_props() {
      return ResponseEntity.ok(accountsDetails);
    }

}
