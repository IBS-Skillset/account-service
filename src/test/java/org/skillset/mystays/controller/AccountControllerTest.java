package org.skillset.mystays.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skillset.mystays.controller.AccountController;
import org.skillset.mystays.model.Account;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class AccountControllerTest {
    @Inject
    AccountController accountController;

    @BeforeEach
    public void setUp(){
        accountController = Mockito.mock(AccountController.class);
    }

    @Test
    public void testInsert() {
        Account account = new Account(5L, "testmail1@gmail.com", "test5", "user5", "xxxx", "32323232");
        Mockito.when(accountController.insert(account)).thenReturn(true);
        given().accept(ContentType.JSON).request()
                .contentType(ContentType.JSON)
                .when().post("account/api")
                .then()
                .statusCode(200);
    }

    @Test
    public void testInsertWithoutUserDetails() {
        Mockito.when(accountController.insert(new Account())).thenReturn(false);
        given().
                when().post("account/api").
                then().
                assertThat().
                equals(false);
        Assertions.assertFalse(accountController.insert(new Account()));
    }

}