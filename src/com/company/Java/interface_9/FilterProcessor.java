package com.company.Java.interface_9;

//适配器模式
public class FilterProcessor {
  public static void main(String[] args) {
    Wavefrom w = new Wavefrom();
    Apply.Process(new FilterAdapter(new Lowpass()), w);
    Apply.Process(new FilterAdapter(new HighPass()), w);
  }
}
