package com.bytetest.accountmanagerapi.controller;

import com.bytetest.accountmanagerapi.request.GiftCardAccountRequest;
import com.bytetest.accountmanagerapi.response.AccountResponse;
import com.bytetest.accountmanagerapi.response.GiftCardAccountResponse;
import com.bytetest.accountmanagerapi.impl.GiftCardAccountImpl;
import com.bytetest.accountmanagerapi.service.GiftCardAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/giftcardaccounts")
@Validated
public class GiftCardAccountController {
    private final GiftCardAccountService service;

    public GiftCardAccountController(GiftCardAccountService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<GiftCardAccountResponse> createGiftCardAccount(@RequestBody @Validated GiftCardAccountRequest request) {
        GiftCardAccountResponse createdAccount = service.createGiftCardAccount(request);
        return ResponseEntity.ok(createdAccount);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GiftCardAccountResponse> findById(@PathVariable Long id) {
        Optional<GiftCardAccountResponse> account = service.getGiftCardAccount(id);
        return account.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiftCardAccountResponse> updateGiftCardAccount(
            @PathVariable Long id,
            @RequestBody @Validated GiftCardAccountRequest request) {
        GiftCardAccountResponse updatedAccount = service.updateGiftCardAccount(id, request);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiftCardAccount(@PathVariable Long id) {
        service.deleteGiftCardAccount(id);
        return ResponseEntity.noContent().build();
    }
}