package com.pp.sun.controller;


import com.pp.sun.dto.AccountResponse;
import com.pp.sun.dto.CreateAccountRequest;
import com.pp.sun.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/account")
@AllArgsConstructor
public class AccountRestController {

    private AccountService accountService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/create"
    )
    public ResponseEntity<String> createAccount(
            @RequestBody CreateAccountRequest createAccountRequest) {
        return ResponseEntity.ok(accountService.createAccount(createAccountRequest));
    }

    @GetMapping(path = "/get/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountResponse> getAccounts(@PathVariable String accountNumber) throws Throwable {
        return ResponseEntity.ok(accountService.getAccount(accountNumber));
    }

    @PutMapping(path = "/deposit/{accountNumber}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountResponse> depositAmount(@PathVariable String accountNumber,@PathVariable BigDecimal amount) throws Throwable {
        return ResponseEntity.ok(accountService.depositAmount(accountNumber,amount));
    }

    @PutMapping(path = "/withdraw/{accountNumber}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountResponse> withdrawAmount(@PathVariable String accountNumber,@PathVariable BigDecimal amount) throws Throwable {
        return ResponseEntity.ok(accountService.withdrawAmount(accountNumber,amount));
    }

}
