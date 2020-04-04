package com.company.Java.TypeInfo_14;

public class FancyToyTest {
    static void printInfo(Class cc) {
      System.out.println(cc.getName() + " xxx " + cc.isInterface());
    }
    public static void main(String[] args) {
      Class c = null;
      try {
        c = Class.forName("com.company.Java.TypeInfo_14.FancyToy");
        printInfo(c);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

      for(Class face: c.getInterfaces()) {
        printInfo(face);
      }
      Class up = c.getSuperclass();
      Object obj = null;
      try {
        obj = up.newInstance();
      } catch (Exception e) {
        e.printStackTrace();
        System.exit(1);
      }
      System.out.println(obj.getClass().getName());
    }
}
