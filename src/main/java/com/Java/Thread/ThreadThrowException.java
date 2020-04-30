package src.main.java.com.Java.Thread;

import java.sql.Time;

public class ThreadThrowException {
  public static void main(String[] args) {
    Thread thread = new Thread() {
      public void run() {
        System.out.println("sub thread begin to run");
        System.out.println("sub thread run end");
        throw  new RuntimeException();
      }
    };
    thread.start();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("END");
  }
}
