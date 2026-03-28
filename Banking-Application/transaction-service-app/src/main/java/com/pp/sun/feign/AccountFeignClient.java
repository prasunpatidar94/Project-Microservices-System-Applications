package com.pp.sun.feign;

import com.pp.sun.dto.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(name = "account-service", url = "http://localhost:9001")
public interface AccountFeignClient {

    @PutMapping("/v1/account/deposit/{accountNumber}/{amount}")
    AccountResponse depositAmount(@PathVariable String accountNumber,
                                  @PathVariable BigDecimal amount);

    @PutMapping("/v1/account/withdraw/{accountNumber}/{amount}")
    AccountResponse withdrawAmount(@PathVariable String accountNumber,
                                   @PathVariable BigDecimal amount);
}