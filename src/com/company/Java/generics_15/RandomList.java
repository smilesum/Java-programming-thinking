package com.company.Java.generics_15;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
  private ArrayList<T> storage = new ArrayList<T>();
  private Random random = new Random(33);
  public T select() {
    return storage.get(random.nextInt(storage.size()));
  }
}
