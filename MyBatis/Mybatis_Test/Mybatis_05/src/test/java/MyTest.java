import com.chen.dao.TeacherMapper;
import com.chen.pojo.Student;
import com.chen.pojo.Teacher;
import com.chen.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacher2 = mapper.getTeacher();
        for( Teacher teacher : teacher2  ){
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void getTeacherById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacherById = mapper.getTeacherById(1);
        System.out.println(teacherById);

        sqlSession.close();
    }

    @Test
    public void getTeacherById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacherById = mapper.getTeacherById2(1);
        System.out.println(teacherById);

        sqlSession.close();
    }
}
