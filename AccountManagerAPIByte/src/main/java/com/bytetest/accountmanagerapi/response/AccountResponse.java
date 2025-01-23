package com.bytetest.accountmanagerapi.response;

import com.bytetest.accountmanagerapi.enums.AccountStatus;

import java.util.Date;
import java.util.Map;

public record AccountResponse(
        Long id,
        Long number,
        String description,
        String name,
        Date registrationDate,
        AccountStatus status,
        Map<String, String> properties
) {


}
