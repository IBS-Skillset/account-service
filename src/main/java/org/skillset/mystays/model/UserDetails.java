package org.skillset.mystays.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    public long id;
    public String email;
    public String firstName;
    public String lastName;
    public String role;
    public String phone;
    public Address address;
}
