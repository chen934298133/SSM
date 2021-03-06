package com.chen.dao;

import com.chen.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//    获取全部用户
    List<User> getUserList();

//    根据id查询用户
    User getUserById(int id);
    //万能map
    User getUserById2(Map<String , Object> map);

//    insert一个用户
    int addUser(User user);

    //万能map
    int addUser2(Map<String , Object> map);

//    修改用户
    int updateUser(User user);

//    删除用户
    int deleteUser(int id);

    List<User> getUserLike(String string);
}
