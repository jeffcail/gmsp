package com.caixiaoxin.gmsp.controller;

import com.caixiaoxin.gmsp.entity.User;
import com.caixiaoxin.gmsp.mapper.UserMapper;
import com.caixiaoxin.gmsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return userMapper.findAll();
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }


    // 分页查询
    // 接口路径  /user/page
    // @RequestParam接受
    @GetMapping("/list/page")
    public Map<String, Object> listPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> users = userMapper.selectPage(pageNum, pageSize);
        List<User> userList = userMapper.findAll();
        Integer total = userList.size();
        Map<String, Object> res = new HashMap<>();
        res.put("data", users);
        res.put("total", total);
        return res;
    }

}
