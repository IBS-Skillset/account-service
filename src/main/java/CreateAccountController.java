import org.skillset.mystays.entity.Account;
import org.skillset.mystays.service.CreateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping(value = "/account", consumes = MediaType.APPLICATION_JSON)
public class CreateAccountController {

    @Autowired
    private CreateAccountService accountService;

    @PostMapping("/insert")
    public boolean createAccount(@RequestBody Account account) {
        return accountService.service(account);
    }
}