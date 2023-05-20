package com.caixiaoxin.gmsp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caixiaoxin.gmsp.controller.dto.UserRequest;
import com.caixiaoxin.gmsp.entity.User;
import com.caixiaoxin.gmsp.mapper.UserMapper;
import com.caixiaoxin.gmsp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 太阳上的雨天
 * @since 2023-05-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean login(UserRequest userRequest) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userRequest.getUsername());
        queryWrapper.eq("password", userRequest.getPassword());
        List<User> list = list(queryWrapper);
        return list.size() != 0;
    }
}
