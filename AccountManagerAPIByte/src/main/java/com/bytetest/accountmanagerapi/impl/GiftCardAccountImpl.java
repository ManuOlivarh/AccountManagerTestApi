package com.bytetest.accountmanagerapi.impl;

import com.bytetest.accountmanagerapi.exception.ResourceNotFoundException;
import com.bytetest.accountmanagerapi.model.Account;
import com.bytetest.accountmanagerapi.model.GiftCardAccount;
import com.bytetest.accountmanagerapi.repository.AccountRepository;
import com.bytetest.accountmanagerapi.repository.GiftCardAccountRepository;
import com.bytetest.accountmanagerapi.request.GiftCardAccountRequest;
import com.bytetest.accountmanagerapi.response.GiftCardAccountResponse;
import com.bytetest.accountmanagerapi.service.GiftCardAccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GiftCardAccountImpl implements GiftCardAccountService {
    private final GiftCardAccountRepository giftCardAccountRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public GiftCardAccountImpl(GiftCardAccountRepository giftCardAccountRepository, AccountRepository accountRepository) {
        this.giftCardAccountRepository = giftCardAccountRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public GiftCardAccountResponse createGiftCardAccount(GiftCardAccountRequest request) {
        Account existingAccount = accountRepository.findByNumber(request.number())
                .orElseThrow(() -> new ResourceNotFoundException("Account number not found - first create an account"));;

        GiftCardAccount giftCardAccount = new GiftCardAccount();
        giftCardAccount.setAccount(existingAccount);
        giftCardAccount.setEmail(request.email());
        giftCardAccount.setCardCode(request.cardCode());
        giftCardAccount.setBalance(request.balance());
        giftCardAccountRepository.save(giftCardAccount);

        return new GiftCardAccountResponse(
                giftCardAccount.getId(),
                giftCardAccount.getEmail(),
                giftCardAccount.getBalance()
        );
    }

    @Transactional
    public Optional<GiftCardAccountResponse> getGiftCardAccount(Long id) {
        return giftCardAccountRepository.findById(id).map(account ->
                new GiftCardAccountResponse(
                        account.getId(),
                        account.getEmail(),
                        account.getBalance()
                )
        );
    }
    @Transactional
    public GiftCardAccountResponse updateGiftCardAccount(Long id, GiftCardAccountRequest request) {
        GiftCardAccount giftCardAccount = giftCardAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GiftCardAccount not found"));

        giftCardAccount.setEmail(request.email());
        giftCardAccount.setCardCode(request.cardCode());
        giftCardAccount.setBalance(request.balance());
        giftCardAccountRepository.save(giftCardAccount);

        return new GiftCardAccountResponse(
                giftCardAccount.getId(),
                giftCardAccount.getEmail(),
                giftCardAccount.getBalance()
        );
    }



    @Transactional
    public void deleteGiftCardAccount(Long id) {
        GiftCardAccount giftCardAccount = giftCardAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GiftCardAccount not found or already deleted"));
        giftCardAccountRepository.delete(giftCardAccount);
    }


}