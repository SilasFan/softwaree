package com.softwaree.softwaree.backend.controller;


import com.softwaree.softwaree.backend.entity.User;
import com.softwaree.softwaree.backend.mapper.UserMapper;
import com.softwaree.softwaree.backend.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fetter
 * @since 2019-11-22
 */
@RestController
@RequestMapping("/backend/user")
public class UserController {

    private UserServiceImpl userService;
}

