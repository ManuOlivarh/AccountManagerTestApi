package com.bytetest.accountmanagerapi.repository;

import com.bytetest.accountmanagerapi.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository  extends JpaRepository<BankAccount, Long> {
}
