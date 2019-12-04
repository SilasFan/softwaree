package com.softwaree.softwaree;

import com.softwaree.softwaree.backend.entity.User;
import com.softwaree.softwaree.backend.service.impl.UserServiceImpl;
import com.softwaree.softwaree.backend.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = {SoftwareeApplication.class})
public class UserTest {
    @Resource
    UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void getUser() {
        User user = userService.getById(1);
    }

    @Test
    public void authTest() {
        User user = userService.getById(1);
        String token = JwtUtil.generateToken(user);
        System.out.println(token);
        System.out.println(JwtUtil.parseToken(token).toString());
    }
}
