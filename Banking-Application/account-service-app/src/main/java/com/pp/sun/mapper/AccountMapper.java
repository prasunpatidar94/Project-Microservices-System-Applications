package com.pp.sun.mapper;

import com.pp.sun.dto.AccountResponse;
import com.pp.sun.entries.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountResponse  accountEntityToResponseDto(Account account){
        return AccountResponse.builder()
                .accountNumber(account.getAccountNumber())
                .customerId(account.getCustomerId())
                .status(account.getStatus().name())
                .balance(account.getBalance())
                .build();
    }

}
