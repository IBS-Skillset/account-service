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
    private String type;
    private String address;
    private String city;
    private String country;
    private Integer zipcode;
}
