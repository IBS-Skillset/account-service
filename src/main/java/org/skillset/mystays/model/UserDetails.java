package org.skillset.mystays.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.skillset.mystays.entity.UserAddress;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
    private String phone;
    private UserAddress address;
}
