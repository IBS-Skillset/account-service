package org.skillset.mystays.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.skillset.mystays.entity.UserAddress;

import java.util.List;

public interface AddressRepository extends PanacheRepository<UserAddress> {
  public  List<UserAddress> findByUserId(Long id);
}
