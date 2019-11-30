package com.softwaree.softwaree.backend.controller;


import com.softwaree.softwaree.backend.entity.User;
import com.softwaree.softwaree.backend.mapper.UserMapper;
import com.softwaree.softwaree.backend.service.impl.UserServiceImpl;
import com.softwaree.softwaree.backend.utils.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author fetter
 * @since 2019-11-29
 */
@RestController
@RequestMapping("/backend")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "hello", httpMethod = "GET", notes = "hello test")
    private User getHello() {
        return userMapper.selectById(1);
    }

    @ApiOperation(value = "register", httpMethod = "POST", notes = "register a new user")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private Response register(@RequestBody User user) {
        return userService.register(user);
    }
}

