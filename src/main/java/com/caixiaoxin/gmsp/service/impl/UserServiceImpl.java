package com.caixiaoxin.gmsp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caixiaoxin.gmsp.common.Constants;
import com.caixiaoxin.gmsp.controller.dto.UserRequest;
import com.caixiaoxin.gmsp.entity.User;
import com.caixiaoxin.gmsp.exception.ServiceException;
import com.caixiaoxin.gmsp.mapper.UserMapper;
import com.caixiaoxin.gmsp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


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

    private static final Log LOG = Log.get();

    @Override
    public UserRequest login(UserRequest userRequest) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userRequest.getUsername());
        queryWrapper.eq("password", userRequest.getPassword());
        User one;
        try {
            one = getOne(queryWrapper);
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_600, "系统错误");
        }

        if (one != null) {
            BeanUtil.copyProperties(one,userRequest, true);
            return userRequest;
        } else {
            throw new ServiceException(Constants.CODE_601, "用户名或密码错误");
        }
    }
}
