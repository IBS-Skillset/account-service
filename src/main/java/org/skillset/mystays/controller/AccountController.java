package org.skillset.mystays.controller;

import org.skillset.mystays.model.Account;
import org.skillset.mystays.model.Address;
import org.skillset.mystays.model.UserDetails;
import org.skillset.mystays.repository.AccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


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

    @GET
    public List<Account> get(){ return accountService.get(); }

    @GET
    @Path("/userdetails/{id}")
    public UserDetails getUserDetails(@PathParam(value = "id")String email){
        return accountService.getUserDetails(email);

    }

}
