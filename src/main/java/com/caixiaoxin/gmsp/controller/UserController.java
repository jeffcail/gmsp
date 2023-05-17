package com.caixiaoxin.gmsp.controller;

import com.caixiaoxin.gmsp.entity.User;
import com.caixiaoxin.gmsp.mapper.UserMapper;
import com.caixiaoxin.gmsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public Integer save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/list")
    public List<User> list() {

        List<User> userList = userMapper.findAll();

        return userList;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }

}
