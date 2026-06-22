package com.nsk.digital.nskdigibank.accountservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(name = "errorResponse", description = "This DTO is responsible for handling all the error related details such as error code, error message, error time, etc.")
public class ErrorResponseDTO {

    @Schema(description = "Enter API Path where the error occurred", example = "/api/v1/digitalbankaccount/createAccount")
    private String apiPath;
    @Schema(description = "Enter HTTP Status Code", example = "400 BAD REQUEST")
    private HttpStatus errorCode;
    @Schema(description = "Enter Error Message", example = "Customer already exist with the given mobile number")
    private String errorMessage;
    @Schema(description = "Enter the time when the error occurred", example = "2024-06-01T12:00:00")
    private LocalDateTime errorTime;
}
