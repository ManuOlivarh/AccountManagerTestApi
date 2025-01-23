package com.bytetest.accountmanagerapi.service;

import com.bytetest.accountmanagerapi.request.AccountRequest;
import com.bytetest.accountmanagerapi.response.AccountResponse;

import java.util.Optional;

public interface AccountService {
    AccountResponse createAccount(AccountRequest request);
    AccountResponse updateAccount(Long id, AccountRequest request);
    Optional<AccountResponse> getAccount(Long id);
    void deleteAccount(Long id);
}
