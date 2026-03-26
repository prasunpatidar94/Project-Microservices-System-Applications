package com.pp.sun.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AccountResponse (
        String accountNumber,
        String customerId,
        BigDecimal balance,
        String status) {
}
