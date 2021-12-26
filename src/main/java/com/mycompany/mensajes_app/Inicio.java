/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class Inicio {
    
    public final static void clearConsole()
        {
            try
            {
                final String os = System.getProperty("os.name");

                if (os.contains("Windows"))
                {
                    Runtime.getRuntime().exec("cls");
                }
                else
                {
                    Runtime.getRuntime().exec("clear");
                }
            }
            catch (final Exception e)
            {
                //  Handle any exceptions.
            }
        }
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        
        do { 
            clearConsole();
            System.out.println("--------------");
            System.out.println(" App message ");
            System.out.println("1. Create Message ");
            System.out.println("2. List messages ");
            System.out.println("3. Edit message ");
            System.out.println("4. delete message ");
            System.out.println("5. Exit ");
            
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    MessageServices.createMessage();
                    break;
                case 2:
                    MessageServices.printMessages();
                    break;
                case 4:
                    MessageServices.deleteMessage();
                    break;
                
            }
            
        } while (opcion != 5);
    }
}
