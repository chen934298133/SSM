package com.chen.dao;

import com.chen.pojo.User;
import com.chen.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void getUserList() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

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
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(4,"李狗","123123"));
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
    public void getUserLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> userList = new HashMap<>();
        userList.put("startindex",0);
        userList.put("pageSize",2);
        List<User> userLimit = mapper.getUserLimit(userList);

        for (User user : userLimit ) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public  void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //rowBounds
        RowBounds rowBounds = new RowBounds(1, 2);


        List<User> userList = sqlSession.selectList("com.chen.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : userList  ) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}