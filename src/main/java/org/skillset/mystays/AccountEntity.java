package org.skillset.mystays;

import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
@Table(name = "USERS")
public class AccountEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String lastName;
    @Column(length = 60)
    public String password;
    public String email;
    public String role="USER";
    public boolean enabled = true;

    public String phone;
}