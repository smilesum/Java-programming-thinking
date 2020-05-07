package src.main.java.com.Spring.AOP.Exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
class UserService3 {
  public  ZoneId zoneId = ZoneId.systemDefault();

  public UserService3() {
    System.out.println("UserService init");
    System.out.println("ZoneId = " + zoneId);
  }

  public ZoneId getZoneId() {
    return zoneId;
  }

  public final  ZoneId getZoneIdFinal() {
    return zoneId;
  }
}

@Component
class MailService {
  @Autowired
  UserService3 userService3;

  public String sendMail() {
    //ZoneId zoneId = userService3.zoneId;//will throw null point exception
    //ZoneId zoneId = userService3.getZoneIdFinal();//final cannot be cover
    ZoneId zoneId = userService3.getZoneId();//调用成功
    // 因为代理类只会代理方法，不会去super()父类，所以也就没有父类的成员变量
    //但是代理方法都是通过委托给原始父类的，所以不会空指针异常。
    String dt = ZonedDateTime.now(zoneId).toString();
    return "Send mail, it's " + dt;
  }
}

@Aspect
@Component
class LoggingAspect {

  @Before("execution(public * UserService3.*(..))")
  public void doAccessCheck() {
    System.out.println("[aop do access check]");
  }
}


@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    MailService mailService = context.getBean(MailService.class);
    mailService.sendMail();
  }
}
