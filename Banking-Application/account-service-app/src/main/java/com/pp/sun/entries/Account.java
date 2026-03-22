package com.pp.sun.entries;

import com.pp.sun.dto.AccountStatus;
import com.pp.sun.exceptions.InsufficientBalanceException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String accountNumber;
    @Column(nullable = false)
    private String customerId;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Account(String accountNumber, String customerId) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = BigDecimal.ZERO;
        this.status = AccountStatus.ACTIVE;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public void deposit(BigDecimal amount) {
        validationActive();
        validationAmount(amount);
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        validationActive();
        validationAmount(amount);
        if (this.balance.compareTo(amount) < 0)
            throw new InsufficientBalanceException("Insufficient balance");
        this.balance = this.balance.subtract(amount);
    }

    private void validationAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Invalid amount: " + amount);
    }

    private void validationActive() {
        if (this.status != AccountStatus.ACTIVE)
            throw new IllegalStateException("Account not active: " + this.accountNumber);
    }
}