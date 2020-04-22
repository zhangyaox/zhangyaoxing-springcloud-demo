package com.zhangyaoxing.order.feign;

import com.zhangyaoxing.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
* 如果其他的项目也要 调用 用户的 接口功能 就也要实现 UserFeignClient 这个接口
* */
@Component
@FeignClient(name = "service-user"/*,fallback = UserFeignFalback.class*/)
public interface UserFeignClient {
    @RequestMapping("/user/getUserById")
    public User getUserById(@RequestParam("id") Integer id);

    @RequestMapping("/user/getUserByUser")
    public User getUserByUser(@RequestBody User user);

    @RequestMapping("/user/getUsernameById")
    public User getUsernameById(@RequestParam("id") Integer id);
}
