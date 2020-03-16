package com.company.generics_15;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee> {
    private int size =0;
    private Class[] types = {Coffe1.class, Coffee2.class};
    private static Random random = new Random(34);
    CoffeeGenerator(int sz) {this.size = sz;}
    CoffeeGenerator() {}
    public Coffee next() {
      try {
        return (Coffee) types[random.nextInt(types.length)].newInstance();
      } catch (Exception e) {
        throw new RuntimeException();
      }
    }

    //Implement Iterator interface
    class CoffeeIterator implements Iterator<Coffee> {
      int count = 0 ;
      public boolean hasNext() {return count > 0;}
      public Coffee next() {
        count--;
        return CoffeeGenerator.this.next();
      }
      public void remove() {}
    }
    public Iterator<Coffee> iterator() {
      return new CoffeeIterator();
    }

    public static void main(String[] args) {
      CoffeeGenerator gen = new CoffeeGenerator();
      for(int i=0; i<5; i++) {
        System.out.println(gen.next());
      }
      //TODO: has some problem
//      for(Coffee c : new CoffeeGenerator(5)) {
//
//      }
    }
}
