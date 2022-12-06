package org.skillset.mystays.repository;

import org.skillset.mystays.entity.AccountEntity;
import org.skillset.mystays.entity.UserAddress;
import org.skillset.mystays.model.Account;
import org.skillset.mystays.model.Address;
import org.skillset.mystays.model.UserDetails;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class AccountService {

    public AccountService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    private AddressRepository addressRepository;

    public UserDetails getUserDetails(String emailId) {
        AccountEntity ac = AccountEntity.findById(emailId);
        List<UserAddress> ad = addressRepository.findByUserId(ac.getId());
        return new UserDetails(ac.id, ac.email, ac.firstName, ac.lastName, ac.role, ac.phone, ad.get(0));
    }

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
