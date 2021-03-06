package src.main.java.com.Java.IO_18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExcute {
  public static void command(String command) {
    boolean err = false;
    try {
      Process process = new ProcessBuilder(command.split(" ")).start();
      BufferedReader results = new BufferedReader(
          new InputStreamReader(process.getInputStream())
      );
      String s;
      while((s=results.readLine()) != null) {
          System.out.println(s);
      }
      BufferedReader errors = new BufferedReader(
          new InputStreamReader(process.getErrorStream())
      );
      while((s=errors.readLine()) != null) {
        System.err.println(s);
      }
    } catch (Exception e) {
      if(!command.startsWith("CMD/C"))
        command("CMD/C" + command);
      else
        throw new RuntimeException(e);
    }
    if(err) {
      throw new OSExecuteException("err:" +command);
    }
  }
}
