package com.rosas.demojwt.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroRequest {
    String username;
    String password;
    String firstname;
    String lastname;
    String country;

    //Getter and Setters

}
