package com.chen.dao;

import com.chen.pojo.User;
import com.chen.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void selectUserById(){
        // 利用 MyBatis 工具类 getSqlSession 获取 sqlSessionFactory.openSession()
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 利用 Session 以及 反射 获取接口类的属性及方法
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        // 调用获取到的方法: userDao.getUserList()
        User user = userDao.selectUserById("chen","123123");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void selectUserById2(){

        Map<String, String> map = new HashMap<>();
        map.put("username","chen");
        map.put("pwd","123123");

        // 利用 MyBatis 工具类 getSqlSession 获取 sqlSessionFactory.openSession()
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 利用 Session 以及 反射 获取接口类的属性及方法
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        // 调用获取到的方法: userDao.getUserList()
        User user = userDao.selectUserById2(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(9,"jack","123123");
        System.out.println(userMapper.addUser(user));
        sqlSession.commit();//提交事务,重点!不写的话不会提交到数据库
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById0(1);
        System.out.println("before: " + user);
        user.setName("rose1");
        System.out.println("after: " + mapper.selectUserById0(1));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("maxId:" + mapper.maxId());
        System.out.println(mapper.deleteUser(9));
        System.out.println("maxId:" + mapper.maxId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectLike1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String wildcardName = "%c%";
        List<User> userList = mapper.selectLike1(wildcardName);
        for (User user : userList){
            System.out.println(user);
        }
    }

//    @Test
//    public void selectLike2(){
//        // SQL注入问题
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        String wildcardName = "c";
//        List<User> userList = mapper.selectLike2(wildcardName);
//        for (User user : userList){
//            System.out.println(user);
//        }
//    }
}
