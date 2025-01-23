package com.bytetest.accountmanagerapi.impl;

import com.bytetest.accountmanagerapi.enums.AccountStatus;
import com.bytetest.accountmanagerapi.exception.ResourceNotFoundException;
import com.bytetest.accountmanagerapi.model.Account;
import com.bytetest.accountmanagerapi.repository.AccountRepository;
import com.bytetest.accountmanagerapi.request.AccountRequest;
import com.bytetest.accountmanagerapi.response.AccountResponse;
import com.bytetest.accountmanagerapi.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public AccountResponse createAccount(AccountRequest request) {
        Account account = new Account();
        account.setNumber(request.number());
        account.setDescription(request.description());
        account.setName(request.name());
        account.setRegistrationDate(new Date());
        account.setStatus(AccountStatus.ACTIVE);
        account.setProperties(request.properties());
        accountRepository.save(account);

        return mapToResponse(account);
    }

    @Transactional
    public AccountResponse updateAccount(Long id, AccountRequest request) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        account.setName(request.name());
        account.setNumber(request.number());
        account.setDescription(request.description());
        account.setStatus(AccountStatus.ACTIVE);
        account.setProperties(request.properties());
        accountRepository.save(account);

        return mapToResponse(account);
    }

    @Transactional
    public Optional<AccountResponse> getAccount(Long id) {
        return accountRepository.findById(id).map(this::mapToResponse);
    }

    @Transactional
    public List<AccountResponse> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Transactional
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    private AccountResponse mapToResponse(Account account) {
        return new AccountResponse(
                        account.getId(),
                        account.getNumber(),
                        account.getName(),
                        account.getDescription(),
                        account.getRegistrationDate(),
                        account.getStatus(),
                        account.getProperties()
                );
    }
}
