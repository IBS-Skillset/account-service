package org.skillset.mystays.repository;

import org.skillset.mystays.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreateAccountRepository extends JpaRepository<Account, Integer> {
}
