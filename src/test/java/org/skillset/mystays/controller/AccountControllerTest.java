package org.skillset.mystays.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skillset.mystays.model.Account;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
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
        given().body("{\"id\": \"5\", \"email\": \"testmail1@gmail.com\", \"firstName\": \"test5\", \"user5\": \"Banner\", \"password\": \"xxxx\", \"phoneNumber\": \"91787878787878\"}").accept(ContentType.JSON).request()
                .contentType(ContentType.JSON)
                .when().post("account/api/signup")
                .then()
                .statusCode(200);
    }

    @Test
    public void testInsertWithoutUserDetails() {
        Mockito.when(accountController.insert(new Account())).thenReturn(Response.status(200).entity(false).build());
        given().
                when().post("account/api").
                then().
                assertThat().
                equals(false);
    }
}