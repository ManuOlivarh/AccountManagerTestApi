package com.bytetest.accountmanagerapi.model;

import com.bytetest.accountmanagerapi.enums.LoanPaymentState;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoanAccountPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short version;

    private Integer paymentNumber;

    private Date date;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private LoanPaymentState state;

    @ManyToOne
    @JoinColumn(name = "loan_account_id")
    private LoanAccount loanAccount;
}