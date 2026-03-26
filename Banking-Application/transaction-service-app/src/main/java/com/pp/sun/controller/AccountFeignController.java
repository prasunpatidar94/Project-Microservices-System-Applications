package com.pp.sun.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigDecimal;

@FeignClient(name = "account-service-app")
public interface AccountFeignController {

    @PutMapping(path = "/v1/account/deposit/{accountNumber}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountResponse> depositAmount(@PathVariable String accountNumber,@PathVariable BigDecimal amount) throws Throwable ;
}
