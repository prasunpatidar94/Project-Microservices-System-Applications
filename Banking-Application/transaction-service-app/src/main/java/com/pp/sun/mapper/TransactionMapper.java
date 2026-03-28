package com.pp.sun.mapper;

import com.pp.sun.dto.TransactionResponse;
import com.pp.sun.entiry.Transaction;
import org.springframework.stereotype.Component;

public class TransactionMapper {

    public static TransactionResponse transcectionEntityToDtoMapper(Transaction transaction) {
        return TransactionResponse.builder()
                .accountNumber(transaction.getAccountNumber())
                .refrenceId(transaction.getReferenceId())
                .amount(transaction.getAmount())
                .build();
    }

}
