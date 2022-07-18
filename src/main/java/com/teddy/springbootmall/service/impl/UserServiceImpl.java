package com.teddy.springbootmall.service.impl;

import com.teddy.springbootmall.dao.UserDao;
import com.teddy.springbootmall.dto.UserRegisterRequest;
import com.teddy.springbootmall.model.User;
import com.teddy.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
