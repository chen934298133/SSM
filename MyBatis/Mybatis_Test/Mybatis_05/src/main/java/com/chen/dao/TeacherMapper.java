package com.chen.dao;

import com.chen.pojo.Student;
import com.chen.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeacher();

    Teacher getTeacherById(@Param("idd")int id);
    Teacher getTeacherById2(@Param("idd")int id);

}
