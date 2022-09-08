package org.skillset.mystays;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    AccountService accountService;

    @GET
    public List<Account> get(){
        return accountService.get();
    }

    @POST
    public void insert(Account account){
        accountService.insert(account);
    }

    @PUT
    public void update(Account account){
        accountService.update(account);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        accountService.delete(id);
    }
}
