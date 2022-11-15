package org.skillset.mystays.controller;

import org.skillset.mystays.model.Account;
import org.skillset.mystays.repository.AccountService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("account/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountController {

    @Inject
    AccountService accountService;

    @POST
    public boolean insert(Account account){
        return accountService.insert(account);
    }

}
