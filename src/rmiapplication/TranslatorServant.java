/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class TranslatorServant extends UnicastRemoteObject implements TranslatorInterface{
    
    static Scanner sc;
    TranslatorServant() throws RemoteException{
        super();
        
        translator.put("hello", "bonjour");
        translator.put("sir", "monsieur");
        translator.put("how", "comment");
        translator.put("is", "est");
        translator.put("i", "je");
        translator.put("am", "un m");
        translator.put("working", "traivalle");
        translator.put("today", "aujourd'hui");
        translator.put("are", "sent");
        translator.put("you", "vous");
        translator.put("us", "nous");
        translator.put("it", "il");
        translator.put("hey", "hey");
    }

    @Override
    public void translate(String msg) throws RemoteException {
        String [] str = msg.split(" ");
        String translation ="";
        Set set = translator.keySet();
        Iterator it = set.iterator();
        for(String s : str){
            set = translator.keySet();
            it = set.iterator();
            while(it.hasNext()){
                Object o = it.next();
                if(o.toString().equalsIgnoreCase(s))
                    translation = translation+" "+translator.get(o.toString());
            }
            
        }
        if(translation =="")
            System.out.println("Sorry, No Translation available for sentence");
        else 
                System.out.println("English :"+msg+", Translation :"+translation);
    }

    @Override
    public void startProcess() throws RemoteException {
        sc = new Scanner(System.in);
        int choice=0;
        do{
            System.out.println("1- Enter Sentence to Translate \n2- Quit");
            choice = sc.nextInt();
            if(choice ==1)
                getSentence();
        }
        while(choice!=2);
    
    }
    public void getSentence() throws RemoteException{
        sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Sentence to translate :");
        String s;
        try {
            s = bf.readLine();
        
        System.out.println("s:"+s);
        translate(s);
        } catch (IOException ex) {
            Logger.getLogger(TranslatorServant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
