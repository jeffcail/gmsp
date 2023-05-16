package com.caixiaoxin.gmsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class GmspApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmspApplication.class, args);
    }


    @GetMapping("/ping")
    public String ping() {
        return "pong...";
    }

}
