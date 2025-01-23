package com.bytetest.accountmanagerapi.model;

import com.bytetest.accountmanagerapi.enums.CardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String cardNumber;

    private Date expirationDate;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}