package src.main.java.com.designmodel.proxymodel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballMachineTestDrive {
  public static void main(String[] args) {
    GumballMachineRemoteInterface gumballMachineRemoteInterface = null;
    int count = 0;
    if(args.length < 2) {
      System.out.println("GumballMachine <name> <inventory>");
      System.exit(1);
    }

    try {
      count = Integer.parseInt(args[1]);
      gumballMachineRemoteInterface = new GumballMachineRealize(args[0], count);
      Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachineRemoteInterface);
    } catch (RemoteException | MalformedURLException e) {
      e.printStackTrace();
    }
  }
}
