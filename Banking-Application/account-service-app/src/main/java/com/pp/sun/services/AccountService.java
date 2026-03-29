package com.pp.sun.services;

import com.pp.sun.dto.AccountResponse;
import com.pp.sun.dto.CreateAccountRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface AccountService {
    String createAccount(CreateAccountRequest createAccountRequest);

    AccountResponse getAccount(String customerId) throws Throwable;

    AccountResponse depositAmount(String accountNumber, BigDecimal amount);

    AccountResponse withdrawAmount(String accountNumber, BigDecimal amount);
}
