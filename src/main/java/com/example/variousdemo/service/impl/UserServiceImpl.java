package com.example.variousdemo.service.impl;

import com.example.variousdemo.entity.User;
import com.example.variousdemo.mapper.UserMapper;
import com.example.variousdemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vicente
 * @since 2021-08-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
