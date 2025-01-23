package com.bytetest.accountmanagerapi.model;

import com.bytetest.accountmanagerapi.genericattribue.Attributes;
import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
public class GiftCardAccount extends Attributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activationCode;
    private String email;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private String cardCode;

    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public String getEmail() {
        return email;
    }

    public Account getAccount() {
        return account;
    }

    public String getCardCode() {
        return cardCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}