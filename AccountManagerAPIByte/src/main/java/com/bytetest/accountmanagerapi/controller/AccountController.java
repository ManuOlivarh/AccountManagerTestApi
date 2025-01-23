package com.bytetest.accountmanagerapi.controller;

import com.bytetest.accountmanagerapi.exception.ResourceNotFoundException;
import com.bytetest.accountmanagerapi.request.AccountRequest;
import com.bytetest.accountmanagerapi.response.AccountResponse;
import com.bytetest.accountmanagerapi.impl.AccountImpl;
import com.bytetest.accountmanagerapi.response.GiftCardAccountResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@Validated
public class AccountController {

    private final AccountImpl accountService;

    @Autowired
    public AccountController(AccountImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest request) {
        AccountResponse accountResponse = accountService.createAccount(request);
        return ResponseEntity.ok(accountResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponse> updateAccount(@PathVariable Long id, @Valid @RequestBody AccountRequest request) {
        return ResponseEntity.ok(accountService.updateAccount(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable Long id) {
        Optional<AccountResponse> account = accountService.getAccount(id);
        return account.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        List<AccountResponse> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
