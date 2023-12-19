package com.project.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Schema(
        name = "Account",
        description = "An object to hold Account information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    @Schema(
            name = "accountNumber",
            example = "1234567890"
    )
    @NotEmpty(message = "Account number cannot be null or empty")
    private Long accountNumber;


    @Schema(
            name = "accountType",
            example = "SAVINGS"
    )
    @NotEmpty(message = "Account type cannot be null or empty")
    private String accountType;


    @Schema(
            name = "branchAddress",
            example = "123, Avenue Street, New York, USA"
    )
    @NotEmpty(message = "Branch address cannot be null or empty")
    private String branchAddress;
}
