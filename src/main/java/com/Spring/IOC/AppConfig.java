package src.main.java.com.Spring.IOC;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class MailService {

  public String sendMail() {
    return "mail";
  }
}

@Component
class UserService {
  @Autowired MailService mailService;

  public String Login() {
    return "login," + mailService.sendMail();
  }
}

@ComponentScan
@Configuration
public class AppConfig {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    UserService userService = context.getBean(UserService.class);
    Assertions.assertEquals(userService.Login(), "login,mail");
  }
}
