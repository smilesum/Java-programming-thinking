package com.company.interface_9;

public class Filter {
  public String name() {
    return getClass().getSimpleName();
  }
  public Wavefrom process(Wavefrom input) {return input;}
}
