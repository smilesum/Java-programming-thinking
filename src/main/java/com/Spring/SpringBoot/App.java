package main.java.com.Spring.SpringBoot;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

//  @Bean
//  public DataSource dataSource() {
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//    dataSource.setUsername("mysqluser");
//    dataSource.setPassword("mysqlpass");
//    dataSource.setUrl(
//        "jdbc:mysql://localhost:3306/myDb?createDatabaseIfNotExist=true");
//
//    return dataSource;
//  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(App.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      String[] names = ctx.getBeanDefinitionNames();
      Arrays.sort(names);
      for(String beanName: names) {
        System.out.println(beanName);
      }
    };
  }
}

