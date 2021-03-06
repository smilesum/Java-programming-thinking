package src.main.java.com.Java.TypeInfo_14;

import java.util.ArrayList;
import java.util.List;

class CountedInteger {
  private static long counter;
  private final long id = counter++;
  public String toString() {
    return  Long.toString(id);
  }
}

public class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type) {
      this.type = type;
    }
    public List<T> create(int n) {
      List<T> result = new ArrayList<>();
      try {
        for(int i=0;i<n;i++) {
          result.add(type.newInstance());
        }
      } catch (Exception e) {
        throw  new RuntimeException();
      }
      return result;
    }
    public static void main(String[] args) {
      FilledList<CountedInteger> fl = new FilledList<>(CountedInteger.class);
      System.out.println(fl.create(5));
    }
}
