package src.main.java.com.Spring.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
class LoggingAspect {

  @Before("execution(public * UserService.*(..))")
  public void doAccessCheck() {
    System.out.println("aop check");
  }

  @Around("execution(public * UserService.Login(..))")
  public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("[Around start]" + pjp.getSignature());
    Object retVal = pjp.proceed();
    System.out.println("[Around end]" + pjp.getSignature());
    return retVal;
  }
}


@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public  class AppConfig {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    UserService userService = context.getBean(UserService.class);
    userService.Login();
    userService.access();
  }
}