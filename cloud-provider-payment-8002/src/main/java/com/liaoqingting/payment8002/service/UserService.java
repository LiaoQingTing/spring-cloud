package com.liaoqingting.payment8002.service;

import com.liaoqingting.springcloud.model.User;

public interface UserService {

    User getUserById(int id);

    int insertUser(User user);
}
