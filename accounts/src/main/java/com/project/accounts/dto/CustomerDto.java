package com.project.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        name = "Customer",
        description = "Object to hold customer and account information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    @Schema(
            name = "name",
            example = "Amith"
    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "Length of name muste be between 5 and 30")
    private String name;



    @Schema(
            name = "email",
            example = "amith@gmail.com"
    )
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email address must be a valid one")
    private String email;


    @Schema(
            name = "mobileNumber",
            example = "0123456789"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;


    @Schema(
            description = "Account details object"
    )
    private AccountDto accountDto;
}
