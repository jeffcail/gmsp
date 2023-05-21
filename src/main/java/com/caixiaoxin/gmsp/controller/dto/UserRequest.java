package com.caixiaoxin.gmsp.controller.dto;


import com.caixiaoxin.gmsp.entity.Menu;
import lombok.Data;

import java.util.List;

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
    private List<Menu> menus;
}

