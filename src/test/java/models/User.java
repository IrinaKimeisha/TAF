package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String zip;


}
