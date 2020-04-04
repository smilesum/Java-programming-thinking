package src.main.java.com.Java.generics_15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BankTeller {
  public static void main(String[] args) {
    Queue<Customer> line = new LinkedList<>();
    Generators.fill(line, Customer.generator(), 5);
    for(Customer customer: line) {
      System.out.println(customer.getId());
    }
    List<Teller> tellers = new ArrayList<>();
    Generators.fill(tellers, Teller.generator, 4);
    for(Teller teller:tellers) {
      System.out.println(teller.getId());
    }
  }
}
