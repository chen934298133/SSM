package com.chen.config;

import com.chen.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.chen.pojo")
@Import(ConfigTest.class)
public class ConfigTest {
    @Bean
    public User getUser(){
        return new User();
    }
}
