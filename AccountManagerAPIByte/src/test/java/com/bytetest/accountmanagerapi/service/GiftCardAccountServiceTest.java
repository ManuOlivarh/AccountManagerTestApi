package com.bytetest.accountmanagerapi.service;

import com.bytetest.accountmanagerapi.impl.GiftCardAccountImpl;
import com.bytetest.accountmanagerapi.model.Account;
import com.bytetest.accountmanagerapi.model.GiftCardAccount;
import com.bytetest.accountmanagerapi.repository.AccountRepository;
import com.bytetest.accountmanagerapi.repository.GiftCardAccountRepository;
import com.bytetest.accountmanagerapi.request.GiftCardAccountRequest;
import com.bytetest.accountmanagerapi.response.GiftCardAccountResponse;
import jakarta.validation.constraints.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class GiftCardAccountServiceTest {
    @Mock
    private GiftCardAccountRepository giftCardAccountRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private GiftCardAccountImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createGiftCardAccount_WithValidAccount_ShouldSucceed() {

                GiftCardAccountRequest request = new GiftCardAccountRequest(
                1001l,
                "Descripcion para prueba unitaria",
                "emaildeusuario@email.com",
                "416541",
                BigDecimal.valueOf(50.00)
        );

        GiftCardAccountResponse response = service.createGiftCardAccount(request);
        assertEquals("Email:", response.email(), request.email());
        assertEquals("CardCode:", response.email(), request.email());
        assertNotNull(response);
        System.out.println(response);
        verify(accountRepository, times(1)).findByNumber(1001L);
        verify(giftCardAccountRepository, times(1)).save(any(GiftCardAccount.class));
    }


}
