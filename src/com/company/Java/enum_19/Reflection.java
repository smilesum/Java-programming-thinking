package com.company.Java.enum_19;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explore{Here, There};

public class Reflection {
  public static Set<String> analyze(Class<?> enumClass) {
    for(Type t: enumClass.getGenericInterfaces()) {
      System.out.println("EEEEE" +t);
    }

    System.out.println("Base class:" + enumClass.getSuperclass());
    Set<String> methods = new TreeSet<>();
    for(Method method: enumClass.getMethods()) {
      methods.add(method.getName());
    }
    System.out.println(methods);
    return methods;
  }

  public static void main(String[] args) {
    analyze(Explore.class);
  }
}
