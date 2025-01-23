package com.bytetest.accountmanagerapi.request;

import jakarta.validation.constraints.NotBlank;

import java.util.Map;

public record AccountRequest(
        Long number,
        String description,
        String activationCode,
        @NotBlank
        String name,
        Map<String, String> properties
) {}