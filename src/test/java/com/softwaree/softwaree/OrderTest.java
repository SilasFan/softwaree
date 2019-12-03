package com.softwaree.softwaree;

import com.softwaree.softwaree.backend.entity.Order;
import com.softwaree.softwaree.backend.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest(classes = {SoftwareeApplication.class})
public class OrderTest {
    @Resource
    private OrderMapper orderMapper;

    @Test
    public void createOrder() {
        Order order = new Order();
        order.setCreateTime(LocalDateTime.now());
        order.setId(0L);
        order.setCustomerID(2L);

        orderMapper.selectById(5);
    }
}
