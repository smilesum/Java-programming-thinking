package src.main.java.com.Java.IO_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {
  static String file = "all/src/main/company/IO_18/test2";
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(
        new StringReader(BufferedInputFile.read("all/src/main/company/IO_18/test"))
    );
    PrintWriter out = new PrintWriter(file);
    String s;
    int count  = 0;
    while((s=in.readLine()) != null) {
      out.println(count++ + " "+ s);
    }
    out.close();
  }
}
