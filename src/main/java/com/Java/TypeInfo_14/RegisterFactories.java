package src.main.java.com.Java.TypeInfo_14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//工厂模式
interface Factory<T> {
  T create();
}

class Part {
  static List<Factory<? extends Part>> partFactories = new ArrayList<>();
  static Random rand = new Random(47);
  public static Part createRandom() {
    int n = rand.nextInt(partFactories.size());
    return partFactories.get(n).create();
  }
  static {
    partFactories.add(new AirFilter.Factory());
    partFactories.add(new OilFilter.Factory());
  }
}

class Filter extends Part {}

class AirFilter extends Filter {
  public static class Factory implements src.main.java.com.Java.TypeInfo_14.Factory<AirFilter> {
    public AirFilter create() {
      return new AirFilter();
    }
  }
}

class OilFilter extends Filter {
  public static class Factory implements src.main.java.com.Java.TypeInfo_14.Factory<OilFilter> {
    public OilFilter create() {
      return new OilFilter();
    }
  }
}

public class RegisterFactories {
  public static void main(String[] args) {
    for(int i=0;i<5;i++) {
      System.out.println(Part.createRandom());
    }
  }
}
