package src.main.java.com.Java.String;

import java.util.Arrays;
import java.util.StringJoiner;
import org.junit.jupiter.api.Assertions;

public class join {
  public static void main(String[] args2) {
    String[] args = {"robin", "jackMa", "ponyMa"};
    StringJoiner  sj = new StringJoiner(", ", "hello ", "!");
    Arrays.stream(args).forEach(sj::add);
    Assertions.assertEquals("hello robin, jackMa, ponyMa!", sj.toString());

    String result = String.join(", ", args);
    Assertions.assertEquals("robin, jackMa, ponyMa", result);
  }
}
