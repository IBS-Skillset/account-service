package org.skillset.mystays.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Account {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
}
