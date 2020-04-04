package com.company.Java.interface_9;

public class Apply {
  public static void Process(Processor p, Object o) {
    System.out.println("using Processor " + p.name());
    System.out.println(p.process(o));
  }
}
