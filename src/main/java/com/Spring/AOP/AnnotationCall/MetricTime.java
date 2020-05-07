package src.main.java.com.Spring.AOP.AnnotationCall;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MetricTime {
  String value();
}

@Component
class UserService2 {

  @MetricTime("register")
  public void register() {
    System.out.println("user register");
  }
}

@Aspect
@Component
class MetricAspect {

  @Around("@annotation(metricTime)")
  public Object metric(ProceedingJoinPoint joinPoint, MetricTime metricTime) throws Throwable {
    String name = metricTime.value();
    long start = System.currentTimeMillis();
    try {
      joinPoint.proceed();
      Thread.sleep(20);
      System.out.println("proceed " + name);
    } finally {
      long t = System.currentTimeMillis() - start;
      System.out.println("[cost time]" + t);
    }
    return null;
  }
}

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
class Test {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
    UserService2 userService2 = context.getBean(UserService2.class);
    userService2.register();
  }
}