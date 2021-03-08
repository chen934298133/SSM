package com.chen.service;

import com.chen.dao.UserDao;


public class UserServiceImpl implements UserService {
    private UserDao userDao;

    //使用set进行动态值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser(){
        userDao.getUser();
    }
}
