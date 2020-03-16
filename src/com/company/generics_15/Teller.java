package com.company.generics_15;

public class Teller {
  private static long counter = 1;
  private final long id = counter++;
  public long getId() {
    return id;
  }
  private Teller() {};
  public static Generator<Teller> generator = new Generator<Teller>() {
    @Override
    public Teller next() {
      return new Teller();
    }
  };
}
