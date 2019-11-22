package com.softwaree.softwaree;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.softwaree.softwaree.backend.entity.User;
import com.softwaree.softwaree.backend.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SoftwareeApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        try {
            User user = new User(4L, "a", "b", "c");
            System.out.println(user.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

}
