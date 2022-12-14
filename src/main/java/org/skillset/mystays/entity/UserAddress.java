package org.skillset.mystays.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_address")
public class UserAddress extends PanacheEntity {
    @Column(name = "type")
    public String type = "permanent";
    @Column(name = "address")
    public String address;
    @Column(name = "city")
    public String city = "New york";
    @Column(name = "country")
    public String country = "USA";
    @Column(name = "zipcode")
    public String zipcode;
    @ManyToOne(cascade = CascadeType.MERGE)
    public AccountEntity user;
}


