package com.bytetest.accountmanagerapi.service;

import com.bytetest.accountmanagerapi.request.GiftCardAccountRequest;
import com.bytetest.accountmanagerapi.response.GiftCardAccountResponse;

import java.util.Optional;

public interface GiftCardAccountService {
    GiftCardAccountResponse createGiftCardAccount(GiftCardAccountRequest request);
    Optional<GiftCardAccountResponse> getGiftCardAccount(Long id);
    GiftCardAccountResponse updateGiftCardAccount(Long id, GiftCardAccountRequest request);
    void deleteGiftCardAccount(Long id);
}
