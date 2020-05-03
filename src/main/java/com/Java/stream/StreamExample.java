package src.main.java.com.Java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;


class Student {

  public String name = "li yan hong";
  Student(){};
  public Student(Integer x) {
    score = x;
  }
  public Integer score;
  public Integer getScore() {
    return score;
  }
}

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
     * reduce TODO
     * */
    System.out.println("Reduce");
    Optional<String> result = Stream.of("I", "love", "you", "too").
        reduce((s1, s2) -> s1.length()>s2.length()?s1:s2);
    System.out.println(result.get());

    Integer result2 = Stream.of("I", "love", "you", "too").reduce(0, (sum, str) -> sum + str.length(),
        (a, b) -> a+b);
    System.out.println(result2);

    /**
     * collect
     * */
    List<String> list1 = Stream.of("I", "love", "you", "too").collect(Collectors.toList());
    List<String> list = Stream.of("I", "love", "you", "too").collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    Set<String> set = Stream.of("I", "love", "you", "too").collect(Collectors.toSet());
    ArrayList<String> arrayList = Stream.of("I", "love", "you", "too").collect(Collectors.toCollection(ArrayList::new));
    HashSet<String> hashSet = Stream.of("I", "love", "you", "too").collect(Collectors.toCollection(HashSet::new));

    Stream<Student> students = Stream.of(new Student(), new Student(), new Student());
    Map<Student, String> map = students.collect(Collectors.toMap(Function.identity(), student -> student.name));

    students = Stream.of(new Student(1), new Student(2), new Student(3));
    Map<Boolean, List<Student>> map2 = students.collect(Collectors.partitioningBy(s -> s.score > 2));
    Assertions.assertEquals(map2.get(true).get(0).score, 3);

    students = Stream.of(new Student(1), new Student(2), new Student(2));
    Map<Integer, List<Student>> student2 = students.collect(Collectors.groupingBy(Student::getScore));
    Assertions.assertEquals(student2.get(2).size(),2);

    students = Stream.of(new Student(1), new Student(2), new Student(2));
    Map<Integer, Long> map1 = students.collect(Collectors.groupingBy(Student::getScore, Collectors.counting()));
    Assertions.assertEquals(map1.get(2), 2);

    students = Stream.of(new Student(1), new Student(2), new Student(2));
    Map<Integer, List<Integer>>  map3 = students.collect(Collectors.groupingBy(Student::getScore,
        Collectors.mapping(Student::getScore, Collectors.toList())));
    Assertions.assertEquals(map3.get(2).get(0), 2);

    String join = Stream.of("I", "love", "you").collect(Collectors.joining(","));
    Assertions.assertEquals(join, "I,love,you");

    /**
     * parallel stream
     * */
    IntStream intStream = IntStream.range(0, 10);
    Set<Thread> threadSet = new HashSet<>();
    intStream.parallel().forEach(i -> {
      Thread thread = Thread.currentThread();
      threadSet.add(thread);
    });
    threadSet.stream().distinct().forEach(System.out::println);
  }
}
































