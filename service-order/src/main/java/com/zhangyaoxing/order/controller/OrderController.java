package com.zhangyaoxing.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "getUserByUserFallback")//里面写的是方法的名称  这个也是报错时直接就调用getUserByUserFallback方法
    public Order getOrderById(@RequestParam("id") Integer id){
        Order order = orderService.getOrderById(id);

        User userParam = new User();//service-user是被调用服务名称，spring.application.name的名称
        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id="+order.getUserId(), User.class);
//        User user = userFeignClient.getUserById(id);
        userParam.setId(1);
        User user = userFeignClient.getUserById(id);
        log.info("user:{}",user);
        order.setUsername(user.getUsername());
        return order;
    }

    public Order getUserByUserFallback(Integer u){//这个方法的参数要与userFeignClient的参数一致
        User user=new User();
        user.setUsername("getUserByUserFallback");
        Order order = new Order();
        order.setUsername(user.getUsername());
        return order;
    }
}
