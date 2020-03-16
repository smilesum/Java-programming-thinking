package com.company.generics_15;


public class Customer {
  private static long counter = 1;
  private final long id = counter++;
  private Customer() {}
  public static Generator<Customer> generator() {
    return new Generator<Customer>() {
      @Override
      public Customer next() {
        return new Customer();
      }
    };
  }
  public long getId() {
    return id;
  }
}
