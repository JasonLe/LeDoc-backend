package com.example.ledoc.controller;

import com.example.ledoc.common.result.Result;
import com.example.ledoc.entity.User;
import com.example.ledoc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whl
 * @Description 登陆类
 * @date 2023/4/30 16:54
 */
@RestController
public class LoginControler {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("/info")
    public Result info() {
        System.out.println("进来了");
        return Result.success();
    }
}
