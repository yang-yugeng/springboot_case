package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.dao.UserMapper;
import com.atguigu.springboot.pojo.User;
import com.atguigu.springboot.service.UserService;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

//    @Resource
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    //propagation传播行为:7种
    //isolation事务隔离级别:4种
    //1.未提交读 READ_UNCOMMITTED
    //问题:数据丢失 ,脏读 ,不可重复 ,幻读
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            rollbackFor = Exception.class)
    @Override
    public List<User> findAll() {
        //int i = 1/0; //运行时异常，Spring AOP 声明式事务，默认对于运行时异常进行回滚。
        //FileInputStream xxx = new FileInputStream("xxx");  //编译期异常；默认不回滚的

        List<User> users = (List<User>) redisTemplate.boundValueOps("userkey").get();
        if (users == null) {//缓存没有

            users = userMapper.selectAll();
            System.out.println("从数据库users = " + users);
            redisTemplate.boundValueOps("userkey").set(users);
        }else{//缓存中有
            System.out.println("从缓存中users = " + users);
        }

        return users;
    }
}
