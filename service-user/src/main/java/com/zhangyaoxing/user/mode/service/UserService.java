package com.zhangyaoxing.user.mode.service;

import com.zhangyaoxing.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserByid(Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername("userName"+id);
        return user;
    }

    public String getUsernameByid(Integer id){
        User userByid = getUserByid(id);
        return userByid.getUsername();
    }
}
