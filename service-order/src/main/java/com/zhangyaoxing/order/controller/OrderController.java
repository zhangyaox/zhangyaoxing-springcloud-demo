package com.zhangyaoxing.order.controller;

import com.zhangyaoxing.entity.User;
import com.zhangyaoxing.order.feign.UserFeignClient;
import com.zhangyaoxing.order.mode.Order;
import com.zhangyaoxing.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("getOrderById")
    public Order getOrderById(@RequestParam("id") Integer id){
        Order order = orderService.getOrderById(id);

        //service-user是被调用服务名称，spring.application.name的名称  http://localhost:8182/user/getUserById?id=1
        User user = restTemplate.getForObject("http://service-user/user/getUserById?id="+order.getUserId(), User.class);
//        User user = userFeignClient.getUserById(id);

//        User user = new User();
//        user.setId(1);
//        User userByUser = userFeignClient.getUserByUser(user);
//        log.info("user:{}",user);
        order.setUsername(user.getUsername());
        return order;
    }
}
