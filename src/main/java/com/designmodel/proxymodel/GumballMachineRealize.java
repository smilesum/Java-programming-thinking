package src.main.java.com.designmodel.proxymodel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachineRealize extends UnicastRemoteObject implements
    GumballMachineRemoteInterface {

  private int count;
  private State state;
  private String location;

  protected GumballMachineRealize(String location, int num) throws RemoteException {
    this.location = location;
    this.count = num;
  }

  @Override
  public int getCount() throws RemoteException {
    return count;
  }

  @Override
  public String getLocation() throws RemoteException {
    return location;
  }

  @Override
  public State getState() throws RemoteException {
    return state;
  }
}
