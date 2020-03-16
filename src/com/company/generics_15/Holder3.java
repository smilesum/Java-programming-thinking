package com.company.generics_15;

class Automobile {}

public class Holder3<T> {
  private T a;
  public Holder3(T a) {this.a = a;}
  public T get() {return this.a;}
  public void main(String[] args) {
    Holder3<Automobile> holder3 = new Holder3<Automobile>(new Automobile());
    Automobile automobile = holder3.get();
  }
}
