package src.main.java.com.Java.generics_15;

public class Example<T> {
  T first;
  T second;

  public Example(Class<T> clazz) throws IllegalAccessException, InstantiationException {
    first = clazz.newInstance();
    second = clazz.newInstance();
  }

  public static void main(String[] args)
      throws InstantiationException, IllegalAccessException {

    Example<String> example = new Example<>(String.class);

  }
}
