package org.skillset.mystays.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Address {
    public String type;
    public String address;
    public String city;
    public String country;
    public String zipcode;
}
