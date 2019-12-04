package com.softwaree.softwaree.backend.controller;


import com.softwaree.softwaree.backend.entity.User;
import com.softwaree.softwaree.backend.mapper.UserMapper;
import com.softwaree.softwaree.backend.service.impl.UserServiceImpl;
import com.softwaree.softwaree.backend.utils.JwtUtil;
import com.softwaree.softwaree.backend.utils.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserServiceImpl userService;

    @RequestMapping(value = "token", method = RequestMethod.GET)
    @ApiOperation(value = "hello", httpMethod = "GET", notes = "hello test")
    private String getToken() {
        User user = userMapper.selectById(1);
        return JwtUtil.generateToken(user);
    }

    @ApiOperation(value = "register", httpMethod = "POST", notes = "register a new user")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private Response register(@RequestBody User user) {
        return userService.register(user);
    }

    @ApiOperation(value = "login", httpMethod = "POST", notes = "user login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Response login(@RequestBody User user) {
        return userService.login(user);
    }

    @ApiOperation(value = "get current user's id", httpMethod = "GET", notes = "为了创建订单方便，返回当前id")
    @RequestMapping(value = "/id/{user_name}", method = RequestMethod.GET)
    private Response getCurrntID(@PathVariable("user_name") String userName) {
        return userService.getCurrentUserID(userName);
    }

    @RequestMapping(value = "/atest", method = RequestMethod.GET)
    private String userTest() {
        return "hello";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    private String helloo() {
        return "hello";
    }
}

