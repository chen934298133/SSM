package com.chen.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//等价于 <bean id="user" class="com.chen.dao.User"/>
@Component
public class User {
    @Value("chen")
    public String name;

}
