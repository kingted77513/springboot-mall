package com.teddy.springbootmall.dao;

import com.teddy.springbootmall.dto.UserRegisterRequest;
import com.teddy.springbootmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
