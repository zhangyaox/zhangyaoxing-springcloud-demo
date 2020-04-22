package com.zhangyaoxing.user.mode.controller;

import com.zhangyaoxing.entity.User;
import com.zhangyaoxing.user.mode.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUserById")
    public User getUserById(@RequestParam("id") Integer id){
        log.info("userId:{}",id);
        return userService.getUserByid(id);
    }

    @RequestMapping("getUserByUser")
    public User getUserByUser(@RequestBody User user){
        log.info("userId:{}",user.getId());
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userService.getUserByid(user.getId());
    }

    /**
     * 根据Id，查询用户名称
     * @param id
     * @return
     */
    @RequestMapping("getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id){
        return userService.getUsernameByid(id);
    }
}
