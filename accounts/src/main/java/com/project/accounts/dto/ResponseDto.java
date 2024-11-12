package com.project.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;


@Schema(
        name = "Response",
        description = "Object to hold success response information"
)
@Data
@AllArgsConstructor
public class ResponseDto {

    @Schema(
            name = "statusCode",
            example = "201 | 200"
    )
    private String statusCode;

    @Schema(
            name = "statusMsg",
            example = "Account created successfully"
    )
    private String statusMsg;
}
