package com.company.interface_9;

public class Lowpass extends Filter {
  public String process(Object o) {
    return ((String)o).toLowerCase();
  }
}
