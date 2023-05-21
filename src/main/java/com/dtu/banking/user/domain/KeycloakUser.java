package com.dtu.banking.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeycloakUser {
    private String id;
    private String username;
    private Boolean enabled;
    private String email;
    private Boolean emailVerified;
    private String firstName;
    private String lastName;

    public String fullName() {
        return String.join(" ", lastName, firstName);
    }
}
