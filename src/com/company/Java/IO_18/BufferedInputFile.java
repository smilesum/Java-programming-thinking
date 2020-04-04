package com.company.Java.IO_18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
  public static String read(String fileName) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(fileName));
    String s;
    StringBuilder sb = new StringBuilder();
    while((s=in.readLine()) != null) {
      sb.append(s + "\n");
    }
    in.close();
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
//    File file2 = new File(".", "file2.txt");
//    file2.createNewFile();
    System.out.println(read("./src/com/company/IO_18/test"));
  }
}
