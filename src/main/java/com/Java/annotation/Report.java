package src.main.java.com.Java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Assertions;

@Inherited
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {
  int type() default 0;
  String level() default "0";
  String value() default "value";
}

class Person {
  @Report(type = 2, level = "10", value = "vvvv")
  public void doIt() {

  }
}

class Test {
  public static void main(String[] args) throws NoSuchMethodException {
    Report report = Person.class.getMethod("doIt").getAnnotation(Report.class);
    Boolean result = false;
    if(report != null) {
      if(report.value().length() < Integer.parseInt(report.level())) {
        result = true;
      }
    }
    Assertions.assertEquals(result, true);
  }
}

