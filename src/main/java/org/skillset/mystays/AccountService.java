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
            return new Account(ac.id, ac.email, ac.firstName, ac.lastName, ac.password, ac.phoneNumber);
        }).collect(Collectors.toList());
    }

    @Transactional
    public void insert(Account account) {
        AccountEntity ac = new AccountEntity();
        ac.email = account.getEmail();
        ac.firstName = account.getFirstName();
        ac.lastName = account.getLastName();
        ac.password = account.getPassword();
        ac.phoneNumber = account.getPhoneNumber();
        ac.persist();
    }

    @Transactional
    public void update(Account account) {
        AccountEntity entity = AccountEntity.findById(account.getId());
        entity.email = account.getEmail();
        entity.firstName = account.getFirstName();
        entity.lastName = account.getLastName();
        entity.password = account.getPassword();
        entity.phoneNumber = account.getPhoneNumber();
    }

    @Transactional
    public void delete(Long id) {
        AccountEntity.deleteById(id);
    }

}
