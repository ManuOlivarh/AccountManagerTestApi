package com.bytetest.accountmanagerapi.repository;

import com.bytetest.accountmanagerapi.model.LoanAccountPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanAccountPaymentRepository extends JpaRepository<LoanAccountPayment, Long> {
}
