/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


/**
 *
 * @author ADMIN
 */
public class Servant extends UnicastRemoteObject implements RmiInterface{
    
    static Scanner sc = new Scanner(System.in);
    static Servant s ;
    Servant() throws RemoteException{
        super();
        
        
    }
    

    @Override
    public void printContainers(String loc) throws RemoteException {
        Container c =null;
        int i =0;
        System.out.println("size:"+containerList.size());
        for (int j = 0; j < containerList.size(); j++) {
            c = (Container)containerList.get(j);
            if(c.getDestination().equalsIgnoreCase(loc)){
                System.out.println(c);
                i++;
            }
        }
    
        if(i==0)
            System.out.println("No containers are set towards Destination "+loc+".");
            
       
    }

    @Override
    public void cancelContainer(String id) throws RemoteException {
       int i =0;
       Container c=null;
        for (int j = 0; j < containerList.size(); j++) {
            c = containerList.get(j);
            if(c.getContainerId().equalsIgnoreCase(id)){
                containerList.remove(j);
                i++;
            }
        
            if(i==0)
                System.out.println("No container found with id "+id);
            else
                System.out.println("Container cancelled Sucessfully.");
        }
    }

    @Override
    public void scheduleContainer() throws RemoteException {
         try{
            Container c = new Container();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Container id:");
            c.setContainerId(sc.next());
            System.out.print("Enter Container Type:");
            c.setContainerType(sc.next());
            System.out.print("Enter Container Destination:");
            c.setContainerDest(sc.next());
            System.out.print("Enter Container length:");
            c.setLength(sc.nextFloat());
            System.out.print("Enter Container Width:");
            c.setWidth(sc.nextFloat());
            System.out.print("Enter Container Height:");
            c.setHeight(sc.nextFloat());
            System.out.print("Enter Container Weight:");
            c.setWeight(sc.nextFloat());
            System.out.print("Enter Container Carrier:");
            c.setCarrier(sc.next());
            System.out.print("Enter Container Color:");
            c.setContainerColor(sc.next());
            System.out.print("Enter Departure Time :");
            c.setDeptTime(sc.next());
            System.out.print("Enter Departure Date:");
            c.setDeptDate(sc.next());
            containerList.add(c);
            System.out.println("Container Scheduled Successfully.");
           
        }
        catch(Exception e){
            System.out.println("Invalid input found.");
            
        }
    }
     public void checkContainer(String date){
        int i=0;
        Container c= new Container();
         for (int j = 0; j < containerList.size(); j++) {
             c = containerList.get(j);
             if(c.getDeptDate().equalsIgnoreCase(date)){
                 System.out.println(c);
                 i++;
             }
         }
        if(i==0)
            System.out.println("No Container is scheduled on date :"+date);
    }
    public static void main(String[] args) throws RemoteException {
        s = new Servant();
        s.scheduleContainer();
    }

    @Override
    public void exit() throws RemoteException {
        System.out.println("Thank you for using out CMS. Have a good day :)");
        System.exit(0);
    }
    public void startProcess() throws RemoteException{
        s = new Servant();
        sc = new Scanner(System.in);
        int choice =0;
        
        System.out.println("---------------------------------------------------------------------- ");
        System.out.println("          Container Management System (CIS408, Spring2019)");
        System.out.println("---------------------------------------------------------------------- ");
        do{
            System.out.println("\n1 - Schedule the departure of container.");
            System.out.println("2 - Cancel an existing one.");
            System.out.println("3 - List all existing containers for one location.");
            System.out.println("4 - Check if Containers are scheduled on a particular date.");
            System.out.println("0-  Quit");
            System.out.print("\nYour choice :");
            choice = sc.nextInt();
            if(choice == 1)
                schedule();
            else if(choice ==2)
                cancel();
            else if(choice ==3)
                 list();
            else if(choice == 4)
                check();
            else if(choice == 0)
                s.exit();
            
        }while(choice!=0);
        
        System.out.println("Cliend terminated.");
    }
    public  void cancel() throws RemoteException{
        System.out.println("Enter Id of container you want to cancel: ");
        String id = sc.next();
        cancelContainer(id);
    }
    public  void list() throws RemoteException{
        System.out.print("Enter location name :");
        String loc = sc.next();
        printContainers(loc);
    }
    public  void check() throws RemoteException{
        System.out.print("Enter date to check containers: ");
        String date = sc.next();
        checkContainer(date);
    }
    public static void schedule() throws RemoteException{
        s.scheduleContainer();
        
    }
    
    
}
