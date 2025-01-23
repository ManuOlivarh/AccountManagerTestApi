package com.bytetest.accountmanagerapi.repository;

import com.bytetest.accountmanagerapi.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
