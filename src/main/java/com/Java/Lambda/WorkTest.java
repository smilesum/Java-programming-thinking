package src.main.java.com.Java.Lambda;

public class WorkTest {
  public static void main(String[] args) {
    WorkInterface workInterface = new WorkInterface() {
      @Override
      public void doWork() {
        System.out.println("call in anonymous class");
      }
    };
    workInterface.doWork();

    workInterface = () -> {
      System.out.println("call in lambda");
    };
    workInterface.doWork();

    new Thread(() -> {
      System.out.println("new thread");
    }).start();
  }
}
