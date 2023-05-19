package com.caixiaoxin.gmsp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caixiaoxin.gmsp.entity.User;
import com.caixiaoxin.gmsp.mapper.UserMapper;
import com.caixiaoxin.gmsp.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return userService.removeBatchByIds(ids);
    }


    // 分页查询
    // 接口路径  /user/page
    // @RequestParam接受
    @GetMapping("/list/page")
    public IPage<User> listPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String nickname,
                                @RequestParam(defaultValue = "") String email,
                                @RequestParam(defaultValue = "") String address,
                                @RequestParam(defaultValue = "") String phone) {
        IPage<User> page = new Page<>(pageNum, pageSize);
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
        return userService.page(page, queryWrapper);
    }

}
