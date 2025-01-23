package com.bytetest.accountmanagerapi.repository;

import com.bytetest.accountmanagerapi.model.GiftCardAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftCardAccountRepository extends JpaRepository<GiftCardAccount, Long> {
}
