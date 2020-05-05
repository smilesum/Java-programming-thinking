package src.main.java.com.Spring.IOC.testEnvironment;

import java.time.ZoneId;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * add following option:
 * --jvm_flag=-Dspring.profiles.active=test
 * to: Edit configuration -> Executable-flags
 * */
@Component
class ProfileSource {

  @Autowired ZoneId zoneId;

  @Bean
  @Profile("!test")
  ZoneId createDefault() {
    return ZoneId.of("UTC+08:00");
  }

  @Bean
  @Profile("test")
  ZoneId createZoneId() {
    return ZoneId.of("Z");
  }
}

@ComponentScan
@Configuration
public class ProfileTest {
  public  static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(ProfileTest.class);
    ProfileSource profileSource = context.getBean(ProfileSource.class);
    Assertions.assertEquals("Z", profileSource.zoneId.getId());
  }
}
