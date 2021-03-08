import com.chen.service.UserService;
import com.chen.service.UserServiceImpl;
import com.chen.service.UserServiceImpl_01;
import com.chen.service.UserService_01;

public class MyTest_01 {
    public static void main(String[] args) {
        UserService_01 service = new UserServiceImpl_01();
        service.getUser();
    }
}
