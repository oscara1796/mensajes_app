/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oscar
 */
public class MessagesDAO {
    
    
    public static void createMessages(Messages message){
        try{
           if( !Conexion.verifyConnection())
               Conexion.getConnection();
           PreparedStatement statement = null;
               try{
                   String query = "INSERT INTO messages (message, author_message) VALUES (?,?)";
                   
                   statement= Conexion.connection.prepareStatement(query);
                   statement.setString(1, message.getMessage());
                   statement.setString(2, message.getAuthor());
                   statement.executeUpdate();
                   
                   System.out.println("Message succesfully created ");
                   
               } catch(SQLException e){
                   System.out.println("There was an error creating the message " + e);
               }
        } catch(Exception e){
            System.out.println(e);
        }
       
    }
    
    
    public static ResultSet readMessage(){
        try{
           if( !Conexion.verifyConnection())
               Conexion.getConnection();
           PreparedStatement statement = null;
           ResultSet rs = null;
               try{
                   String query = "SELECT * FROM messages";
                   
                   statement= Conexion.connection.prepareStatement(query);
                   rs= statement.executeQuery();
                   
                   
                   return rs;
               } catch(SQLException e){
                   System.out.println("There was an error creating the message " + e);
               }
           
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    public static void deleteMessage(int Id){
        try{
           if( !Conexion.verifyConnection())
               Conexion.getConnection();
           PreparedStatement statement = null;
         
               try{
                   String query = "DELETE   FROM messages WHERE id_message=?";
                   
                    statement= Conexion.connection.prepareStatement(query);
                   statement.setString(1, String.valueOf(Id));
                   statement.executeUpdate();
                   
                   System.out.println("Message succesfully deleted ");
                   
               } catch(SQLException e){
                   System.out.println("There was an error deleting the message " + e);
               }
           
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public static void updateMessage(String message,int Id){
        try{
           if( !Conexion.verifyConnection())
               Conexion.getConnection();
           PreparedStatement statement = null;
         
               try{
                   String query = "UPDATE  messages  SET message=? WHERE id_message=?";
                   
                    statement= Conexion.connection.prepareStatement(query);
                   statement.setString(1, message);
                   statement.setString(2, String.valueOf(Id));
                   statement.executeUpdate();
                   
                   System.out.println("Message succesfully updated ");
                   
               } catch(SQLException e){
                   System.out.println("There was an error updating the message " + e);
               }
           
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
}
