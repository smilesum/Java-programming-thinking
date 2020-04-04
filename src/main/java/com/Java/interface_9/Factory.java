package src.main.java.com.Java.interface_9;

interface Service {
  void method1();
  void method2();
}

interface serviceFactory {
  Service getService();
}

class serviceImplementation1 implements Service {
  public void method1() {System.out.println("1-1");}
  public void method2() {System.out.println("1-2");}
}

class serviceImplementation2 implements Service {
  public void method1() {System.out.println("2-1");}
  public void method2() {System.out.println("2-2");}
}


class serviceFactoryImplementation1 implements serviceFactory {

  @Override
  public Service getService() {
    return new serviceImplementation1();
  }
}

class serviceFactoryImplementation2 implements serviceFactory {

  @Override
  public Service getService() {
    return new serviceImplementation2();
  }
}

public class Factory {
  public static void serviceConsumer(serviceFactory fact) {
    Service service = fact.getService();
    service.method1();
    service.method2();
  }
  public  static void main(String[] args) {
    serviceConsumer(new serviceFactoryImplementation1());
    serviceConsumer(new serviceFactoryImplementation2());
  }
}

