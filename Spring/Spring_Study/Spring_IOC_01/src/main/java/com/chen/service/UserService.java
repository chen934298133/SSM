package com.chen.service;

import com.chen.dao.UserDao;

public interface UserService {
    public void setUserDao(UserDao userDao);
    public void getUser();
}
