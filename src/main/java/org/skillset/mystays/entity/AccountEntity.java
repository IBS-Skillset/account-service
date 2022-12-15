package org.skillset.mystays.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.util.List;
@Data
@Entity
@Table(name = "USERS")
public class AccountEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String lastName;
    @Column(length = 60)
    public String password;
    @Column(unique=true)
    public String email;
    public String role="USER";
    public boolean enabled = true;
    public String phone;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    public List<UserAddress>  address;
}