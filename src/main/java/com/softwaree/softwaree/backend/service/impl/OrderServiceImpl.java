package com.softwaree.softwaree.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwaree.softwaree.backend.entity.Order;
import com.softwaree.softwaree.backend.mapper.OrderMapper;
import com.softwaree.softwaree.backend.service.IOrderService;
import com.softwaree.softwaree.backend.utils.OrderInfo;
import com.softwaree.softwaree.backend.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    private String UPLOADPATH = "./upload";

    public Response uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return new Response("上传失败！", 0);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String fileName = sdf.format(new Date()) + "--" + file.getOriginalFilename();

        File file1 = new File(UPLOADPATH);
        if (!file1.exists()) {//如果文件夹不存在
            file1.mkdir();//创建文件夹
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADPATH + "/" + fileName);
            Files.write(path, bytes);
            return new Response(path.toString(), 1);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Upload fail!", 0);
        }
    }

    public Response createOrder(Order order) {
        order.setAcceptTime(null);
        order.setTallyTime(null);
        order.setCreateTime(LocalDateTime.now());
        order.setId(0L);
        order.setProduceProgress(new OrderInfo().toString());

        // 这里的customerID需要前端自己用getCurrentID填写，因为类型不同就不查询了
        try {
            this.save(order);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("下单错误！", 0);
        }

        return new Response(1);
    }

    public Response acceptOrder(long orderID) {
        try {
            Order curr = this.getById(orderID);
            if (curr == null || curr.getAcceptTime() != null) {
                return new Response("错误的订单！", 0);
            }
            curr.setAcceptTime(LocalDateTime.now());
            this.updateById(curr);
            return new Response(1);
        } catch (Exception e) {
            return new Response("服务器错误！", 0);
        }
    }

    // 前端自行更新，后端不做处理
    public Response updateOrder(Long id, OrderInfo orderInfo) {
        try {
            Order order = this.getById(id);
            if (order == null) {
                return new Response("没有此订单！", 0);
            }
            order.setProduceProgress(orderInfo.toString());
            System.out.println(orderInfo.toString());
            this.update(order, new UpdateWrapper<Order>().eq("orderID", order.getId()));
        } catch (Exception e) {
            return new Response("Server Error!", 0);
        }

        return new Response(1);
    }

    public Response tallyOrder(Long id) {
        try {
            Order order = this.getById(id);
            if (order == null || order.getTallyTime() != null) {
                return new Response("无法结算订单！", 0);
            }
            order.setTallyTime(LocalDateTime.now());
            this.updateById(order);
        } catch (Exception e) {
            return new Response("Server Error!", 0);
        }

        return new Response(1);
    }

    public Response getOrder(Long id) {
        try {
            Order order = this.getById(id);
            if (order == null) {
                return new Response("订单不存在！", 0);
            }
            return new Response(order, 1);
        } catch (Exception e) {
            return new Response("Server Error!", 0);
        }
    }

    // 这里忘记设有效位了，所以用OrderInfo来代替吧，太不严谨了...
    public Response closeOrder(Long id) {
        try {
            Order order = this.getById(id);
            if (order == null) {
                return new Response("订单不存在！", 0);
            }
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setAccept("closed");
            order.setProduceProgress(orderInfo.toString());
            this.updateById(order);

            return new Response(1);
        } catch (Exception e) {
            return new Response("Server Error!", 0);
        }
    }

    public Response getOrderByUser(Long customerID) {
        try {
            List<Order> orders = this.list(new QueryWrapper<Order>().eq("customerID", customerID));
            return new Response(orders, 1);
        } catch (Exception e) {
            return new Response("server error!", 0);
        }
    }

    public Response allOrders() {
        try {
            List<Order> orders = this.list();
            return new Response(orders, 1);
        } catch (Exception e) {
            return new Response("server error!", 0);
        }
    }
}
