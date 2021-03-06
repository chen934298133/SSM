package com.chen.dao;

import com.chen.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from teacher where id =#{idd}")
    Teacher getTeacher(@Param("idd") int id);
}
