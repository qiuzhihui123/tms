import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        classPathXmlApplicationContext.start();

        System.out.println("加载完毕---------");

        System.in.read();

    }
}
