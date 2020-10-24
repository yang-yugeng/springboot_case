package com.atguigu.springboot;

import com.atguigu.springboot.dao.UserMapper;
import com.atguigu.springboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

//    @Autowired
    @Resource
    private UserMapper userMapper ;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }
}
