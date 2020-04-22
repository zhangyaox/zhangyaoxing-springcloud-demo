package com.zhangyaoxing.entity.service.impl;

import com.zhangyaoxing.entity.entity.User;
import com.zhangyaoxing.entity.mapper.UserMapper;
import com.zhangyaoxing.entity.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhj
 * @since 2020-04-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
