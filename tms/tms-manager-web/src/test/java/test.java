import com.kaishengit.tms.entity.manage.Account;
import com.kaishengit.tms.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");

        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");

        Account account = accountService.findAccountWithRoles(1);
        System.out.println(account);
    }
}
