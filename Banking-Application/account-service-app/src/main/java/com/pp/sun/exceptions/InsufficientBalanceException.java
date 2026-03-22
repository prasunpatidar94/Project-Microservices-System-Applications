package com.pp.sun.exceptions;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String insufficientBalanceSms) {
        super(insufficientBalanceSms);
    }
}
