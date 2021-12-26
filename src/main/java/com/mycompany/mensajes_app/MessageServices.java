/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class MessageServices {
    
    public static void createMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Escribe tu mensaje ");
        String message = sc.nextLine();
        System.out.println("Tu nombre ");
        String name = sc.nextLine();
        
        Messages register = new Messages();
        register.setMessage(message);
        register.setAuthor(name);
        
        MessagesDAO.createMessages(register);
        
    }
    
    
    public static void printMessages(){
        
        try {
            ResultSet rs = MessagesDAO.readMessage();
            while (rs.next()) {
                System.out.println("ID " + rs.getInt("id_message"));
                System.out.println("Message " + rs.getString("message"));                
                System.out.println("Author " + rs.getString("author_message"));                
                System.out.println("Date"  + rs.getString("message_date"));                

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
    
    public static void deleteMessage(){
        
       Scanner sc = new Scanner(System.in);
        System.out.println(" Escribe el ID del  mensaje a eliminar");
        String id = sc.nextLine();
        
        MessagesDAO.deleteMessage(Integer.valueOf(id));
        
        
    }
    
    
    public static void updateMessage(){
        
       Scanner sc = new Scanner(System.in);
        System.out.println(" Escribe el ID del  mensaje a actualizar");
        String id = sc.nextLine();
        System.out.println(" Escribe el mensaje ");
        String message = sc.nextLine();
        
        MessagesDAO.updateMessage(message,Integer.valueOf(id));
        
        
    }
    
}
