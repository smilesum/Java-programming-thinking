package src.main.java.com.Java.Lambda;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;

class Person {
  String name;
  Person(String name) {
    this.name = name;
  }
}

public class example {

  public static void main(String[] args) throws IOException {
    String[] array = new String[]{"AE", "B", "ESS", "D"};
    Arrays.sort(array, (s1, s2) -> s2.length() - s1.length());
    System.out.println(String.join(",", array));

    List<String> names = Arrays.asList("lina","ndd", "anna");
    List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
    Assertions.assertEquals(persons.get(0).name, "lina");
  }
}
