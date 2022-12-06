package org.skillset.mystays.entity;

import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "USERS")
public class AccountEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public long id;

    @OneToMany(mappedBy="account", cascade = CascadeType.ALL)
    public List<UserAddress>  address;

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


}