package org.skillset.mystays.repository;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skillset.mystays.model.Account;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@QuarkusTest
public class AccountServiceTest {

    @Inject
    private AccountService accountService;

    @BeforeEach
    public void setUp(){
        accountService = Mockito.mock(AccountService.class);
    }

    @Test
    public void testInsert(){
        Account account = new Account();
        account.setId(6L);
        account.setEmail("test10@gmail.com");
        account.setFirstName("test10");
        account.setLastName("user10");
        account.setPassword("q3dewewe");
        Mockito.when(accountService.insert(account)).thenReturn(true);
        accountService.insert(account);
        Mockito.when(accountService.insert(new Account())).thenReturn(false);
        assertTrue(accountService.insert(account));
        assertFalse(accountService.insert(new Account()));
    }


}