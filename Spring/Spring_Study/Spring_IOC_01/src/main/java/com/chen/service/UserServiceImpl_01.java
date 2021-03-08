package com.chen.service;

import com.chen.dao.UserDao;
import com.chen.dao.UserDaoImpl;
import com.chen.dao.UserDaoMysqlImpl;

public class UserServiceImpl_01 implements UserService_01 {
    // 变更内容在此处修改实现类
    private UserDao userDao = new UserDaoMysqlImpl();

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
