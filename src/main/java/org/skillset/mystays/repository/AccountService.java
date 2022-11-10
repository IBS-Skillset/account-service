package org.skillset.mystays.repository;

import org.skillset.mystays.entity.AccountEntity;
import org.skillset.mystays.model.Account;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
public class AccountService {

    @Transactional
    public boolean insert(Account account) {
        try {
            AccountEntity ac = new AccountEntity();
            ac.email = account.getEmail();
            ac.firstName = account.getFirstName();
            ac.lastName = account.getLastName();
            ac.password = account.getPassword();
            ac.phone = account.getPhoneNumber();
            ac.persist();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
