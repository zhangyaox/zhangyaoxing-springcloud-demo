package com.zhangyaoxing.order.feign;

import com.zhangyaoxing.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/*
* UserFeignFalback实现了UserFeignClient
* feignclient中指定了
*
* 在 请求失败时 失败哪一个方法 就调用这个类的那个方法 返回固定值 提示报错
* */
@Component
public class UserFeignFalback implements UserFeignClient {
    @Override
    public User getUserById(Integer id) {
        User user1=new User();
        user1.setUsername("值1");
        return user1;
    }

    @Override
    public User getUserByUser(User user) {
        User user1=new User();
        user1.setUsername("值");
        return user1;
    }

    @Override
    public User getUsernameById(Integer id) {
        return null;
    }
}
