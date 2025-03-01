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

    @GetMapping("/health")
    public String healthCheck() {
        return "Up and Running";
    }
}
