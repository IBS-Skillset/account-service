package org.skillset.mystays.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

@Data
@Entity
public class UserAddress extends PanacheEntity {
    @Column(name = "type")
    public String type="permanent";
    @Column(name = "address")
    public String address;
    @Column(name = "city")
    public String city ="New york";
    @Column(name = "country")
    public String country="USA";
    @Column(name = "zipcode")
    public String zipcode;
    @ManyToOne(cascade = CascadeType.ALL)
    public  AccountEntity user;
}
