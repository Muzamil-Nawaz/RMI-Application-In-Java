 package rmiapplication;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
// Creating Remote interface for our application 
public interface TranslatorInterface extends Remote{
    public abstract void translate(String msg) throws RemoteException;
    public abstract void startProcess() throws RemoteException;
    public abstract void getSentence() throws RemoteException;
    HashMap<String,String> translator = new HashMap<>();
    
}
