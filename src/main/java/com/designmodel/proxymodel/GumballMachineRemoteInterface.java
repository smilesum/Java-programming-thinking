package src.main.java.com.designmodel.proxymodel;
import java.rmi.*;

/**
 * service provide by remote server
 * */
public interface GumballMachineRemoteInterface extends Remote {
  public int getCount() throws RemoteException;
  public String getLocation() throws RemoteException;
  public State getState() throws RemoteException;
}
