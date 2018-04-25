import com.kaishengit.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-dubbo.xml");
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");

        System.out.println(userService.getUserName(1));
    }
}
