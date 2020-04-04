package src.main.java.com.Java.generics_15;

import java.util.Iterator;

//迭代器模式
public class Fibnocci {
    private static int count = 0;
    public Integer next() {return fib(count++);}
    public Integer fib(int n) {
       if(n<2) return n;
       return fib(n-1) + fib(n-2);
    }
}

class FibnocciIterator extends Fibnocci implements Iterable<Integer> {
    private int n = 0;
    FibnocciIterator(int sz) {n = sz;}
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

          @Override
          public boolean hasNext() {
            return n >0;
          }

          @Override
          public Integer next() {
            n--;
            return FibnocciIterator.this.next();
          }
        };
    }
    public static void main(String[] args) {
      for(Integer i: new FibnocciIterator(10)) {
        System.out.println(i);
      }
    }
}