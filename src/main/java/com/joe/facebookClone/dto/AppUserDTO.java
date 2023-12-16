package com.joe.facebookClone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserDTO {
    private Integer id;
    private String name;
    private String email;
    private String password;
}