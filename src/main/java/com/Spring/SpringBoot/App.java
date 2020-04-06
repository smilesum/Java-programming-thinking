package main.java.com.Spring.SpringBoot;

import com.google.common.primitives.Ints;

/**
 * This application compares two numbers, using the Ints.compare
 * method from Guava.
 */
public class App {

  public static int compare(int a, int b) {
    return Ints.compare(a, b);
  }

  public static void main(String... args) throws Exception {
    App app = new App();
    System.out.println("Success: " + app.compare(2, 1));
  }

}

//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.boot.SpringApplication;

//@SpringBootApplication
//public class App {
//
//  public static void main(String... args) throws Exception {
//    SpringApplication.run(App.class, args);
//  }
//
//  @Bean
//  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//    return args -> {
//      String[] names = ctx.getBeanDefinitionNames();
//      Arrays.sort(names);
//      for(String beanName: names) {
//        System.out.println(beanName);
//      }
//    };
//  }
//}

