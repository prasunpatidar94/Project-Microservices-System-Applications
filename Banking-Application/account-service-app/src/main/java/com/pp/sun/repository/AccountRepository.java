package com.pp.sun.repository;

import com.pp.sun.entries.Account;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    @Nullable
    Optional<Account> findByCustomerId(String customerId);

    Optional<Account> findByAccountNumber(String accountNumber);
}
