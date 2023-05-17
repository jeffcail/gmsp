package com.caixiaoxin.gmsp.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;

}
