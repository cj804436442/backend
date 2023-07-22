package cj.myapp.backend.controller;
import cj.myapp.backend.enity.Order;
import cj.myapp.backend.mapper.OrderMapper;
import cj.myapp.backend.util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class OrderController {

    @Resource
    OrderMapper orderMapper;
    @PostMapping("/order")
    public Response doOrder(@RequestBody Order order) {
        String food = order.getFood();
        String time = order.getOrderTime();
        String remark = order.getRemark();
        String price = order.getPrice();
        if (food.equals("")) {
            return new Response(100, "菜单不能为空", "");
        } else {
            orderMapper.orderMeal(order);
            return new Response(200, "下单成功", "");
        }
    }
}

