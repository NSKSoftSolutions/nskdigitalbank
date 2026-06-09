package com.nsk.digital.nskdigibankaccount.controller;

import com.nsk.digital.nskdigibankaccount.constants.CustomerConstants;
import com.nsk.digital.nskdigibankaccount.dto.CustomerDTO;
import com.nsk.digital.nskdigibankaccount.dto.ResponseDTO;
import com.nsk.digital.nskdigibankaccount.exceptions.CustomerAlreadyExist;
import com.nsk.digital.nskdigibankaccount.services.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@RestController
@RequestMapping(value="/api/v1/digitalbankaccount")
@Validated
@Tag(name="CUSTOMER SERVICES",description = "This API is responsible for handling all the customer related operations such as onboarding, fetching details, updating details and deleting account")
public class CustomerController {

    @Autowired
    ICustomerService customerService;
    @PostMapping("/customer/onboarding")
    @Operation(summary = "Onboard a new customer", description = "This API is responsible for onboarding a new customer by providing the necessary details such as name, mobile number, email, etc.")
    @ApiResponses({
            @ApiResponse(description = "Customer On-Boarded successfully",responseCode = CustomerConstants.MESSAGE_201),
            @ApiResponse(description = "Customer already exist with the given mobile number",responseCode = CustomerConstants.MESSAGE_400)
    })
    public ResponseDTO addCustomerData(@Valid @RequestBody  CustomerDTO customerDTO) throws CustomerAlreadyExist {
        customerService.onboardCustomer(customerDTO);
       return new ResponseDTO(CustomerConstants.STATUS_200,CustomerConstants.MESSAGE_200);
    }
    @GetMapping(value="/customer/fetch")
    @Operation(summary = "Fetch customer details", description = "This API is responsible for fetching the customer details by providing the mobile number")
    @ApiResponses({
            @ApiResponse(description = "Customer details fetched successfully",responseCode = CustomerConstants.MESSAGE_200),
            @ApiResponse(description = "Customer not found with the given mobile number",responseCode = CustomerConstants.CUSTOMER_DETAILS_NOT_VALID)
    })
    public ResponseEntity<CustomerDTO> findCustomer(@Valid @RequestParam String mobileNumber) throws AccountNotFoundException {
        CustomerDTO customer=customerService.getCustomerDetails(mobileNumber);
       return ResponseEntity.ok(customer);
    }
   @PutMapping(value="/customer/update")
   @Operation(summary = "Update customer details", description = "This API is responsible for updating the customer details by providing the necessary details such as name, mobile number, email, etc.")
   @ApiResponses({
           @ApiResponse(description = "Customer Data Updated successfully",responseCode = CustomerConstants.MESSAGE_201),
           @ApiResponse(description = "Customer details are not valid",responseCode = CustomerConstants.STATUS_400)
   })
   public ResponseEntity<ResponseDTO> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws AccountNotFoundException {

        boolean isUpdated=customerService.updateCustomerDetails(customerDTO);
        if (isUpdated){
            return ResponseEntity.ok(new ResponseDTO(CustomerConstants.STATUS_201,CustomerConstants.MESSAGE_201));
        }else{
            return ResponseEntity.ok(new ResponseDTO(CustomerConstants.STATUS_400,CustomerConstants.MESSAGE_400));
        }
    }
   @DeleteMapping("/customer/remove_cust_account")
   @Operation(summary = "Delete customer account", description = "This API is responsible for deleting the customer account by providing the account number")
   @ApiResponses({
           @ApiResponse(description = "Account Number Associated with the customer deleted successfully",responseCode = CustomerConstants.MESSAGE_202),
           @ApiResponse(description = "Customer details are not valid",responseCode = CustomerConstants.STATUS_400)
   })

   public ResponseEntity<ResponseDTO> deleteAccountForCustomer(@Valid @RequestParam  long accountNumber) throws AccountNotFoundException {
       boolean isDeleted = customerService.deleteCustomerAccount(accountNumber);
       if (isDeleted) {
           return ResponseEntity.ok(new ResponseDTO(CustomerConstants.STATUS_202, CustomerConstants.MESSAGE_202));
       }else {
           return ResponseEntity.ok(new ResponseDTO(CustomerConstants.STATUS_400, CustomerConstants.MESSAGE_400));
       }
   }

}
