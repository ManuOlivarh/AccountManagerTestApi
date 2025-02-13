package com.bytetest.accountmanagerapi.repository;

import com.bytetest.accountmanagerapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByNumber(Long number);

}