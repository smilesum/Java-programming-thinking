package src.main.java.com.Java.generics_15;

public class TwoTupple<A, B> {
  public final A a;
  public final B b;
  public TwoTupple(A a, B b) {this.a = a;this.b = b;}
}

class ThreeTupple<A, B, C> extends TwoTupple {
  public final C c;
  public ThreeTupple(A a, B b, C c) {
    super(a,b);
    this.c = c;
  }
}
