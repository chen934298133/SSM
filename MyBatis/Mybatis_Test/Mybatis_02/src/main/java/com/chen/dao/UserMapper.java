package com.chen.dao;

import com.chen.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//    获取全部用户
    List<User> getUserList();

//    根据id查询用户
    User getUserById(int id);

//    insert一个用户
    int addUser(User user);

//    修改用户
    int updateUser(User user);

//    删除用户
    int deleteUser(int id);

    //分页
    List<User> getUserLimit(Map<String,Integer> map);


    List<User> getUserByRowBounds();



}
