package com.pp.sun.dto;

import java.math.BigDecimal;

public record TransctionRequest(String accountNumber, BigDecimal amount, String refrenceId) {
}
