package rmiapplication;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TranslatorClient {
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
       TranslatorInterface t = (TranslatorInterface) Naming.lookup("rmi://localhost:3067/hello");
        System.out.println("Server Started:");
        t.startProcess();
        
    }
    
}
