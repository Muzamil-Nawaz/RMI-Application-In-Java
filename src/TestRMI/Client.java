/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Client {
    static RmiInterface r;
    static Scanner sc;
    
    public static void main(String[] args) throws  MalformedURLException, RemoteException, NotBoundException {
        
        r = (RmiInterface)Naming.lookup("rmi://localhost:3067/hello");
        r.startProcess();
        System.out.println("Cliend terminated.");
        
    }
    
    
}
