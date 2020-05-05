package src.main.java.com.Spring.IOC.conditional;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

@Component
@Conditional(cond.class)
public class Test {
  public  static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
    Test test = context.getBean(Test.class);
  }
}

class cond implements Condition {

  /**
   * if matches return false,then the Test bean wouldn't be registered.
   * */
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    return true;
  }
}
