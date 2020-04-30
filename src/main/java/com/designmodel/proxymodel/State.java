package src.main.java.com.designmodel.proxymodel;

import java.io.Serializable;

public interface State extends Serializable {
  public void insertQuarter();
  public void ejectQuarter();
  public void turnCrank();
  public void dispense();
}
