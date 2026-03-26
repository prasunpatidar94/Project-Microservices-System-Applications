package com.pp.sun.entiry;

import com.pp.sun.entiry.emum.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @NonNull
    private BigDecimal amount;
    private String referenceId; // Idempotency  Key
    private String accountNumber;
    private LocalDateTime createdAt;

    public Transaction(String accountNumber, TransactionType type, BigDecimal amount, String refrenceId) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.referenceId = refrenceId;
        this.createdAt = LocalDateTime.now();
    }



}
