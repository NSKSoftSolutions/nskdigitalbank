package com.nsk.digital.nskdigibank.accountservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name="Response", description = "This DTO is responsible for handling all the response related details such as status code, status message, etc.")
public class ResponseDTO {

    @Schema(description = "Enter Status Code", example = "201")
    private String statusCode;
    @Schema(description = "Enter Status Message", example = "Account created successfully")
    private String statusMsg;
}
