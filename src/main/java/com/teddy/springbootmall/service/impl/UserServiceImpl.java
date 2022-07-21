package com.teddy.springbootmall.service.impl;

import com.teddy.springbootmall.dao.UserDao;
import com.teddy.springbootmall.dto.UserLoginRequest;
import com.teddy.springbootmall.dto.UserRegisterRequest;
import com.teddy.springbootmall.model.User;
import com.teddy.springbootmall.service.UserService;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        // 檢查註冊的 email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if (user != null){
            log.warn("該 email {} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        userRegisterRequest.setPassword(getHashedPassword(userRegisterRequest.getPassword()));

        // 創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    private String getHashedPassword(String password) {
        // 使用 MD5 生成密碼的雜湊值
        return DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        if (user == null){
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 比較密碼
        if (user.getPassword().equals(getHashedPassword(userLoginRequest.getPassword()))){
            return user;
        }else {
            log.warn("該 email {} 的密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
