
import com.chen.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //用户实际调用的是业务层，dao层他们不需要接触
//        UserService userService = new UserServiceImpl();
//        userService.setUserDao(new UserDaoMysqlImpl());
//        userService.getUser();

        //获取ApplicationContext：拿到spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //容器在手天下我有，需要什么get什么 类似于工厂模式
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();

    }
}
