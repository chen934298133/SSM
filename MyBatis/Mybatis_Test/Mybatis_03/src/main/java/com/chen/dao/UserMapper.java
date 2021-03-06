package com.chen.dao;

import com.chen.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有的参数前面必须加上@Param("id")的注解
    @Select("select *from user where id = #{id1}")
    User getUserById(@Param("id1")int id);

    @Insert("insert into user(id,name,pwd) value (#{id},#{name},#{pwd}) ")
    int addUser(User user);

    @Update("update user set id = #{id},name=#{name},pwd=#{pwd} where name=#{name}")
    int updateUser(User user);

    @Delete("delete from user where id = #{idd}")
    int deleteUser(@Param("idd") int id);
}
