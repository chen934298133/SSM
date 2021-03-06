package com.chen.dao;

import com.chen.pojo.User;
import com.chen.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void getUserList() {

        // 利用 MyBatis 工具类 getSqlSession 获取 sqlSessionFactory.openSession()
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 利用 Session 以及 反射 获取接口类的属性及方法
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        // 调用获取到的方法: userDao.getUserList()
        List<User> userList = userDao.getUserList();

//        一行简化 :
//        List<User> userList1 = MybatisUtils.getSqlSession().getMapper(UserMapper.class).getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }

    @Test
    public void gerUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();

        map.put("id111111",5);
        map.put("name111111","chen");
        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(4,"李狗","123123"));
        sqlSession.commit();
        sqlSession.close();
        getUserList();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("userId",5);
        map.put("userName","chen");
        map.put("userPwd","123123");
        mapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
        getUserList();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(5,"chenchen","456456"));
        sqlSession.commit();
        sqlSession.close();
        getUserList();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
        getUserList();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("李");
        for ( User user : userList  ) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}