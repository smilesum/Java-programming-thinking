package src.main.java.com.designmodel.proxymodel;

public class NoQuarterState implements State {
  transient GumballMachineRealize gumballMachine;

  @Override
  public void insertQuarter() {

  }

  @Override
  public void ejectQuarter() {

  }

  @Override
  public void turnCrank() {

  }

  @Override
  public void dispense() {

  }
}
