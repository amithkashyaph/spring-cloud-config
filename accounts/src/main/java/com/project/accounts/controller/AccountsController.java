package com.project.accounts.controller;

import com.project.accounts.constants.AccountConstants;
import com.project.accounts.dto.*;
import com.project.accounts.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD APIs for Account entity",
        description = "CRUD APIs details for for handling Accounts related actions"
)
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/account", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private IAccountService accountService;

    private AccountsInfoDto accountsInfoDto;

    @GetMapping("/")
    public String sayHello() {
        return "Hello there!!!!";
    }

    @Operation(
            summary = "Create Account REST API",
            description = "Creates Account entity in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Get Account details API",
            description = "API to fetch Account details by mobileNumber"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> getCustomerInfoByMobileNumber(
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 didgits")
            @RequestParam("mobileNumber") String mobileNumber) {
        CustomerDto customerDto = accountService.fetchCustomerByMobileNumber(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }


    @Operation(
            summary = "Update Account REST API",
            description = "REST API to update the Account entity"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountService.updateAccountDetails(customerDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
        }
    }
}
