package com.caixiaoxin.gmsp.service;

import com.caixiaoxin.gmsp.entity.User;
import com.caixiaoxin.gmsp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        if (user.getId() == null) {
            return userMapper.save(user);
        } else {
            return userMapper.update(user);
        }
    }

}
