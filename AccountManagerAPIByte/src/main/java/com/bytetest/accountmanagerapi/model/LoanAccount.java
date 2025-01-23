package com.bytetest.accountmanagerapi.model;

import com.bytetest.accountmanagerapi.enums.LoanType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class LoanAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private LoanType type;

    private Double totalAmount;
    private double loanAmount;
    private double interestRate;
    private Integer totalPayments;

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL)
    private List<LoanAccountPayment> payments;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


}