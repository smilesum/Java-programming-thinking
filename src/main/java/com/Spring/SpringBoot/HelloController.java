package main.java.com.Spring.SpringBoot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@EnableAutoConfiguration
@RestController
public class HelloController {
  @RequestMapping("/")
  public String index() {
    return "hello, world";
  }
}
