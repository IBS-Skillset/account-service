package org.skillset.mystays.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
public class UserAddress extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "address_id")
    public long addressId;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public  AccountEntity user;

    @Column(name = "type")
    public String type;
    @Column(name = "address", nullable = false)
    public String address;
    @Column(name = "city")
    public String city;
    @Column(name = "country")
    public String country;
    @Column(name = "zipcode")
    public Integer zipcode;

}
