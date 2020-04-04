package com.company.Java.TypeInfo_14;

interface f1{}
interface f2{}
interface f3{}

class Toy {
  Toy() {}
  Toy(int i) {}
}

public class FancyToy  extends  Toy implements f1, f2, f3 {
  FancyToy() {
    super(1);
  }
}




