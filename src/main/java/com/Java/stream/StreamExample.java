package src.main.java.com.Java.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExample {
  public static void main(String[] args) {

    /**
     * foreach
     * */
    Stream<String> stream = Stream.of("I", "love", "you");
    stream.forEach(str -> System.out.println(str));

    System.out.println("filter");
    /**
     * filter
     * */
    Stream.of("I", "love", "you").filter(str -> str.length() == 3).forEach(System.out::println);

    System.out.println("distinct");
    /**
     * distinct
     * */
    Stream.of("I", "love", "you", "too", "too").distinct().forEach(System.out::println);


    System.out.println("sorted");
    /**
     * sorted
     * */
    Stream.of("B", "A", "A", "C").sorted((str1, str2) -> str1.length() - str2.length()).forEach(System.out::println);

    System.out.println("map");
    /**
     * map
     * */
    Stream.of("I", "love", "you", "too").map(s -> s.toUpperCase()).forEach(System.out::println);

    System.out.println("flatmap");
    /**
     * flatmap
     * */
    Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5)).flatMap(list -> list.stream()).forEach(i -> System.out.println(i));

    /**
     * reduce
     * */
    
  }
}
































