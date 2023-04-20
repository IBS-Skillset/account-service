package org.skillset.mystays.controller;

import org.skillset.mystays.model.Account;
import org.skillset.mystays.model.UserDetails;
import org.skillset.mystays.repository.AccountService;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("account/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountController {

    @Inject
    AccountService accountService;

    @POST
    @Path("/signup")
    public Response insert(Account account) {
        try {
            return Response.status(200).entity(accountService.insert(account)).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/userdetails/{id}")
    public UserDetails getUserDetails(@PathParam(value = "id")String email){
        return accountService.getUserDetails(email);
    }
}
