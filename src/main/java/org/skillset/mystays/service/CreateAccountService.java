package org.skillset.mystays.service;

import org.skillset.mystays.entity.Account;
import org.skillset.mystays.repository.CreateAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateAccountService {

    @Autowired
    private CreateAccountRepository repository;

    public boolean service(final Account account) {
        try {
            repository.save(account);
            return true;
        } catch (Exception e) {
            System.out.println("New Account Created Successfully");
            return false;
        }
    }

    public List<Account> service1(){
        return repository.findAll();
    }
}
