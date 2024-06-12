package com.project.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "An object details to hold error response"
)
@Data
@AllArgsConstructor
@Builder
public class ErrorResponseDto {

    @Schema(
            name = "apiPath",
            example = "/api/account/create"
    )
    private String apiPath;


    @Schema(
            name = "errorCode",
            example = "400 | 404 | 500"
    )
    private HttpStatus errorCode;


    @Schema(
            name = "errorMessage",
            example = "User already exists"
    )
    private String errorMessage;


    @Schema(
            name = "errorTime",
            example = "9:10AM"
    )
    private LocalDateTime errorTime;

}
