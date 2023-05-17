package com.caixiaoxin.gmsp;

import com.caixiaoxin.gmsp.entity.User;
import com.caixiaoxin.gmsp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@SpringBootApplication
public class GmspApplication {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(GmspApplication.class, args);
    }



    @GetMapping("/")
    public List<User> index() {

        List<User> userList = userMapper.findAll();

        return userList;
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong...";
    }


}
