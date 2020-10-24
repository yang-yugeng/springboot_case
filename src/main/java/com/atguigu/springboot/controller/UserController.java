package com.atguigu.springboot.controller;

import com.atguigu.springboot.pojo.User;
import com.atguigu.springboot.service.UserService;
import com.atguigu.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息
     * @return
     */
    @RequestMapping(path = "/findAll")
    @ResponseBody
    public Result findAll() {
        List<User> users = userService.findAll();
        return Result.ok(users);
    }
}
