package com.softwaree.softwaree.backend.controller;


import com.softwaree.softwaree.backend.entity.Order;
import com.softwaree.softwaree.backend.service.impl.OrderServiceImpl;
import com.softwaree.softwaree.backend.utils.OrderInfo;
import com.softwaree.softwaree.backend.utils.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/backend/order")
public class OrderController {

    @Resource
    private OrderServiceImpl orderService;

    @ApiOperation(value = "upload design file", httpMethod = "POST", notes = "上传芯片设计文件")
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    private Response uploadDesign(@RequestBody MultipartFile file) {
        return orderService.uploadFile(file);
    }

    @ApiOperation(value = "create an order", httpMethod = "POST", notes = "创建订单")
    @RequestMapping(value = "", method = RequestMethod.POST)
    private Response addOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @ApiOperation(value = "accept order", httpMethod = "POST", notes = "厂家接受订单")
    @RequestMapping(value = "accept/{id}", method = RequestMethod.POST)
    private Response acceptOrder(@PathVariable("id") Long id) {
        return orderService.acceptOrder(id);
    }

    @ApiOperation(value = "update produce info", httpMethod = "PUT", notes = "厂家更新订单信息")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    private Response updateOrderInfo(@PathVariable("id") Long id, @RequestBody OrderInfo info) {
        return orderService.updateOrder(id, info);
    }

    @ApiOperation(value = "tally order", httpMethod = "POST", notes = "厂家结算订单")
    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    private Response tallyOrder(@PathVariable("id") Long id) {
        return orderService.tallyOrder(id);
    }

    @ApiOperation(value = "get order info", httpMethod = "GET", notes = "单独获得订单的现在情况")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    private Response getOrder(@PathVariable("id") Long id) {
        return orderService.getOrder(id);
    }

    @ApiOperation(value = "close an order", httpMethod = "DELETE", notes = "关闭订单，订单作废")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    private Response closeOrder(@PathVariable("id") Long id) {
        return orderService.closeOrder(id);
    }

    @ApiOperation(value = "get orders of single user", httpMethod = "GET", notes = "获取该用户所有历史订单")
    @RequestMapping(value = "u/{user_id}", method = RequestMethod.GET)
    private Response getOrdersByUser(@PathVariable("user_id") Long uid) {
        return orderService.getOrderByUser(uid);
    }

    @ApiOperation(value = "get all orders", httpMethod = "GET", notes = "获取所有历史订单，只有厂家才能用")
    @RequestMapping("/all")
    private Response getAll() {
        return orderService.allOrders();
    }
}

