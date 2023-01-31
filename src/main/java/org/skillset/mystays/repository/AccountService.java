package org.skillset.mystays.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.logging.Log;
import org.skillset.mystays.entity.AccountEntity;
import org.skillset.mystays.entity.UserAddress;
import org.skillset.mystays.model.Account;
import org.skillset.mystays.model.Address;
import org.skillset.mystays.model.UserDetails;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AccountService {

    public UserDetails getUserDetails(String emailId) {
        try {
            PanacheQuery<AccountEntity> panacheQueryaccountEntity= AccountEntity.find("email", emailId);
            AccountEntity accountEntity= panacheQueryaccountEntity.list().get(0);
            List<UserAddress>  listOfAddress = UserAddress.list("user", panacheQueryaccountEntity.list().get(0));
            UserAddress userAddress= listOfAddress.get(0);
            Address address = new Address(userAddress.getType(), userAddress.address, userAddress.city, userAddress.country, userAddress.zipcode);
            return new UserDetails(accountEntity.id, accountEntity.email, accountEntity.firstName, accountEntity.lastName, accountEntity.role, accountEntity.phone, address);
        } catch (Exception e) {
            Log.info("User details exception"+e);
            return null;
        }

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
            ac.persistAndFlush();

            UserAddress userAddress = new UserAddress();
            userAddress.address = account.getFirstName() + " address";
            userAddress.user = ac;
            userAddress.zipcode = "23456";
            userAddress.persistAndFlush();
            return true;
        } catch (PersistenceException e) {
            Log.error("Error on Persist data: ", e);
            return false;
        }
    }
}
