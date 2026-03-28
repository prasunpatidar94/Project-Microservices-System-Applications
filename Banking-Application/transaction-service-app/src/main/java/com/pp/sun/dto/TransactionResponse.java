package com.pp.sun.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
public record TransactionResponse(String accountNumber, BigDecimal amount, String refrenceId) {
}
