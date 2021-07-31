package TestRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RmiInterface  extends Remote{
    public void printContainers(String loc) throws RemoteException;
    public void cancelContainer(String id)throws RemoteException;
    public void scheduleContainer() throws RemoteException;
    public void exit() throws RemoteException;
    public void checkContainer(String date) throws RemoteException;
    public void startProcess() throws RemoteException;
    ArrayList<Container>containerList = new ArrayList<>();
}
