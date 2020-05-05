package src.main.java.com.Spring.IOC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

interface Validator {
  void validate(String email, String password, String name);
}

@Component
@Order(1)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class EmailValidator implements Validator {

  @Autowired(required = true)
  ZoneId zoneId = ZoneId.systemDefault();

  @Override
  public void validate(String email, String password, String name) {
    System.out.println("email validate");
  }

  @PostConstruct
  public void init() {
    System.out.println("Init mail service with zoneId = " + this.zoneId);
  }

  @PreDestroy
  public void shutdown() {
    System.out.println("Shutdown mail service");
  }
}

@Component
@Order(2)
class PasswordValidator implements Validator {
  @Override
  public void validate(String email, String password, String name) {
    System.out.println("password validate");
  }
}

@Component
@Order(3)
class NameValidator implements Validator {
  @Override
  public void validate(String email, String password, String name) {
    System.out.println("name validate");
  }
}

@ComponentScan
@Configuration
//@PropertySource("app.properties")
public class CustomBean {

  @Value("file:/Users/eurusouou/Desktop/code/Java_spring_designmodel/src/main/java/com/resources/log.txt")
  private Resource resource;

  @Autowired
  List<Validator> validators;

  void readLog() throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)
    );
    System.out.println(reader.lines().collect(Collectors.joining("\n")));
  }

  public void validate(String email, String password, String name) {
    validators.stream().forEach(validator -> validator.validate(email, password, name));
  }

  @Bean("z")
  ZoneId createZoneIdZ(@Value("${app.zone:Z}") String zoneId) {
    return ZoneId.of(zoneId);
  }

  @Bean("utc")
  @Primary
  ZoneId createZoneIdUTC() {
    return ZoneId.of("UTC+08:00");
  }

  public static void main(String[] args) throws Exception {
    ApplicationContext context = new AnnotationConfigApplicationContext(CustomBean.class);
    ZoneIdFactory zoneIdFactory = context.getBean(ZoneIdFactory.class);
    ZoneId zoneId = zoneIdFactory.getObject();


    EmailValidator emailValidator = context.getBean(EmailValidator.class);
    Assertions.assertEquals(emailValidator.zoneId.getId(), "UTC+08:00");

    Assertions.assertEquals(zoneId.getId(),"Z");
    CustomBean customBean = context.getBean(CustomBean.class);
    customBean.validate("email","password","name");

    customBean.readLog();

    NeedConfig needConfig = context.getBean(NeedConfig.class);
    Assertions.assertEquals(needConfig.smtpHost, "123");
    Assertions.assertEquals(needConfig.smtpPort, 25);
  }
}

//@Component
class ZoneIdFactory implements FactoryBean<ZoneId> {

  String zoneId = "Z";

  @Override
  public ZoneId getObject() throws Exception {
    return ZoneId.of(zoneId);
  }

  @Override
  public Class<?> getObjectType() {
    return ZoneId.class;
  }
}

@Component
class config {
  @Value("123")
  public String host;

  @Value("25")
  public int port;
}

@Component
class NeedConfig {

  @Value("#{config.host}")
  public String smtpHost;

  @Value("#{config.port}")
  public int smtpPort;
}