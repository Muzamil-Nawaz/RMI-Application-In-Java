/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestRMI;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        Registry registry = LocateRegistry.createRegistry(3067);
        
        registry.bind("hello", new Servant());
        
    }
    
}
