package com.nsk.digital.nskdigibankaccount.dto;

import com.nsk.digital.nskdigibankaccount.entites.Accounts;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name="customer",description = "This DTO is responsible for handling all the customer related details such as name, mobile number, email, etc.")
public class CustomerDTO {

    @Schema(name = "name", description = "Enter Customer Name")
    @NotEmpty(message = "Name Cannot be Empty")
    private String name;
    @Schema(description = "Enter Email Address")
    @Email(message = "Email should be valid")
    private String email;
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid Mobile Number, Mobile Number Should be 10 Digits")
    @Schema(description = "Enter Mobile Number", example = "9876543210")
    private String mobileNumber;
    private Accounts account;
}
