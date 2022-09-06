package org.skillset.mystays;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
public class AccountService {

    public List<Account> get() {
        List<AccountEntity> listAll = AccountEntity.findAll().list();
        return listAll.stream().map(ac -> {
            return new Account(ac.id, ac.email, ac.firstName, ac.lastName, ac.password, ac.phone);
        }).collect(Collectors.toList());
    }

    @Transactional
    public void create(Account account) {
        AccountEntity ac = new AccountEntity();
        ac.email = account.getEmail();
        ac.firstName = account.getFirstName();
        ac.lastName = account.getLastName();
        ac.password = account.getPassword();
        ac.phone = account.getPhone();
        ac.persist();
    }

    @Transactional
    public void update(Account account) {
        AccountEntity entity = AccountEntity.findById(account.getId());
        entity.email = account.getEmail();
        entity.firstName = account.getFirstName();
        entity.lastName = account.getLastName();
        entity.password = account.getPassword();
    }

    @Transactional
    public void delete(Long id) {
        AccountEntity.deleteById(id);
    }

}
