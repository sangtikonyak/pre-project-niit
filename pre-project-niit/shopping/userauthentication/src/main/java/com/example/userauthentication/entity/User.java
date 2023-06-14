package com.example.userauthentication.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user_shopping_table")
public class User {

    @Id
    private String email;

    private String password;

    private String role;

}
