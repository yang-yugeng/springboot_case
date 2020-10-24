package com.atguigu.springboot.dao;

import com.atguigu.springboot.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
//通用Mapper,简化mybatis开发
public interface UserMapper extends Mapper<User> {
}
