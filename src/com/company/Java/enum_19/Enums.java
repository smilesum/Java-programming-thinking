package com.company.Java.enum_19;

import java.util.Random;

enum test{A,B,C};

public class Enums {
  private static Random random = new Random(2);
  public static <T extends Enum<T>> T random(Class<T> cls) {
    return random(cls.getEnumConstants());
  }

  public static <T> T random(T[] values) {
    return values[random.nextInt(values.length)];
  }

  public static void main(String[] args) {
    for(int i=0;i<5;i++) {
      System.out.println(Enums.random(test.class));
    }
  }
}
