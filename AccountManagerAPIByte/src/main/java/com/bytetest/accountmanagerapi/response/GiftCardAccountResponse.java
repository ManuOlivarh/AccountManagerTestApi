package com.bytetest.accountmanagerapi.response;

import java.math.BigDecimal;

public record GiftCardAccountResponse(
        Long id,
        String email,
        BigDecimal balance
) {
}
