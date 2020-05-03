package src.main.java.com.Java.Lambda;

import java.io.IOException;
import java.util.Arrays;

public class example {

  public static void main(String[] args) throws IOException {
    String[] array = new String[]{"AE", "B", "ESS", "D"};
    Arrays.sort(array, (s1, s2) -> s2.length() - s1.length());
    System.out.println(String.join(",", array));
  }
}
