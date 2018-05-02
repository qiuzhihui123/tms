import com.kaishengit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-dubbo.xml");
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");

        System.out.println(userService.getUserName(1));
    }
}
