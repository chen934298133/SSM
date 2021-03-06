import com.chen.dao.UserMapper;
import com.chen.pojo.User;
import com.chen.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void selectUser(){
        SqlSession session = MyBatisUtils.getSession();

        //方法一:
        List<User> users1 = session.selectList("com.chen.dao.UserMapper.selectUser");
        //方法二:
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users2 = mapper.selectUser();

        for (User user:users1){
            System.out.println(user);
        }
        session.close();
    }
}
