package com.chen.dao;

import com.chen.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int maxId();
    // 1. 获取全部用户
    List<User> selectUser();
    // 2. 根据id查询用户
    User selectUserById0(int id);
    // 方法一: 直接在方法中传递参数
    User selectUserById(@Param("username") String username,@Param("pwd") String pwd);
    // 方法二: 万能map
    User selectUserById2(Map<String, String> map);
    // 3. 添加一个用户
    Boolean addUser(User user);
    // 4. 根据修改一个用户
    Boolean updateUser(User user);
    // 5. 根据id删除用户
    Boolean deleteUser(int id);
    // 6. 模糊查询like语句
    // 在Java代码中添加sql通配符。
    List<User> selectLike1(String wildcardName);
    // 在sql语句中拼接通配符，会引起sql注入
    // (不推荐)
    List<User> selectLike2(String wildcardName);
}
