package com.caixiaoxin.gmsp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

import com.caixiaoxin.gmsp.service.IUserService;
import com.caixiaoxin.gmsp.entity.User;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 太阳上的雨天
 * @since 2023-05-20
 */
@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping
    public Boolean save(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return userService.removeBatchByIds(ids);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/page")
    public Page<User> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String username,
                               @RequestParam(defaultValue = "") String nickname,
                               @RequestParam(defaultValue = "") String email,
                               @RequestParam(defaultValue = "") String address,
                               @RequestParam(defaultValue = "") String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)) {
            queryWrapper.like("username", username);
        }

        if (!"".equals(nickname)) {
            queryWrapper.like("nickname", nickname);
        }

        if (!"".equals(email)) {
            queryWrapper.like("email", email);
        }
        if (!"".equals(address)) {
            queryWrapper.like("address", address);
        }
        if (!"".equals(phone)) {
            queryWrapper.like("phone", phone);
        }
        queryWrapper.orderByDesc("id");
        return userService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }



}

