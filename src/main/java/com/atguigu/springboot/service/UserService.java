package com.atguigu.springboot.service;

import com.atguigu.springboot.pojo.User;

import java.util.List;

public  interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

}
