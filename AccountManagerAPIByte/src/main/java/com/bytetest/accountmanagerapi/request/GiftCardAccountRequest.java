package com.bytetest.accountmanagerapi.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record GiftCardAccountRequest(
        @NotNull
        Long number,
        String description,
        @Email String email,
        String cardCode,
        BigDecimal balance
) {}