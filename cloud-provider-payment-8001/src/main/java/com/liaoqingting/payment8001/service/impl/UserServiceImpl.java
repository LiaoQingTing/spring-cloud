package com.liaoqingting.payment8001.service.impl;

import com.liaoqingting.payment8001.mapper.UserMapper;
import com.liaoqingting.payment8001.service.UserService;
import com.liaoqingting.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
