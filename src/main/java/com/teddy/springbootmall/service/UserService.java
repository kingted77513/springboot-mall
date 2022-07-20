package com.teddy.springbootmall.service;

import com.teddy.springbootmall.dto.UserLoginRequest;
import com.teddy.springbootmall.dto.UserRegisterRequest;
import com.teddy.springbootmall.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);
}
