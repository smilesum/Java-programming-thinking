package src.main.java.com.Java8.Interface;


import org.junit.jupiter.api.Assertions;

interface Formula {
  double calculate(int a );

  default double sqrt(int a ) {
    return Math.sqrt(a);
  }
}

public class TestDefault {

  public static void main(String[] args) {
    Formula formula = new Formula() {

      @Override
      public double calculate(int a) {
        return sqrt(a * 100);
      }
    };

    Assertions.assertEquals(formula.calculate(100) , 100.0);
  }
}