package com.joe.facebookClone.models;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
//@Table(name = "users_table")
public class AppUsers {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
}
