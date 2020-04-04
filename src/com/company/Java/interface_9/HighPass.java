package com.company.Java.interface_9;

public class HighPass extends Filter {
  public String process(Object o) {
    return ((String)o).toUpperCase();
  }
}
