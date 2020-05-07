package src.main.java.com.Spring.AOP;

import org.springframework.stereotype.Component;

@Component
class UserService {

  public void Login() {
    System.out.println("user login");
  }

  public void access() {
    System.out.println("user access");
  }
}
