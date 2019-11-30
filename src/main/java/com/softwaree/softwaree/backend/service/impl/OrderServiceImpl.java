package com.softwaree.softwaree.backend.service.impl;

import com.softwaree.softwaree.backend.entity.Order;
import com.softwaree.softwaree.backend.mapper.OrderMapper;
import com.softwaree.softwaree.backend.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author fetter
 * @since 2019-11-29
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
