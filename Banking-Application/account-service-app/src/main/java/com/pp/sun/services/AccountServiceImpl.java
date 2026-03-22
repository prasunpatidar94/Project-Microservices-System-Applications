package com.pp.sun.services;

import com.pp.sun.dto.AccountResponse;
import com.pp.sun.dto.CreateAccountRequest;
import com.pp.sun.entries.Account;
import com.pp.sun.mapper.AccountMapper;
import com.pp.sun.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Override
    public String createAccount(CreateAccountRequest createAccountRequest) {

        return STR."\{accountRepository.save(new Account(generateAccountNumber(),
                createAccountRequest.getCustomerId()
        )).getAccountNumber()} Account Created Successfully ...! ";
    }

    @Override
    public AccountResponse getAccount(String accountNumber) throws Throwable {

        return accountMapper.accountEntityToResponseDto(
                accountRepository.findByAccountNumber(accountNumber).orElseThrow(
                        () -> new RuntimeException("Account not found")
                )
        );
    }

    @Override
    public AccountResponse depositAmount(String accountNumber, BigDecimal amount) {

        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new RuntimeException("Account not found"));
        account.deposit(amount);
        return accountMapper.accountEntityToResponseDto(accountRepository.save(account));
    }

    private String generateAccountNumber() {
        return String.format("%012d", new Random().nextLong(1_000_000_000_000L));
    }
}
