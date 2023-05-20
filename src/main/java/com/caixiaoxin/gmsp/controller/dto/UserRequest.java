package com.caixiaoxin.gmsp.controller.dto;


import lombok.Data;

/**
 * 登陆请求参数
 */
@Data
public class UserRequest {
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private String token;
}

