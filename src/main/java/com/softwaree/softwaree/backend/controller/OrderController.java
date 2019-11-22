package com.softwaree.softwaree.backend.controller;


import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/backend/order")
public class OrderController {

    @RequestMapping()
    private Integer a() {
        return 1;
    }

    @PostMapping()
    private Integer b() {
        return 2;
    }

}

