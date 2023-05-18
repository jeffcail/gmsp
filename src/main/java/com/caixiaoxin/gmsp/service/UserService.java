package com.caixiaoxin.gmsp.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caixiaoxin.gmsp.entity.User;
import com.caixiaoxin.gmsp.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public boolean saveUser(User user) {
        return saveOrUpdate(user);
    }

}
