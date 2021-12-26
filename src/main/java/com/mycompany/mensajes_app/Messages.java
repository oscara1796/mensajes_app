/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

/**
 *
 * @author oscar
 */
public class Messages {
    String message;
    String author;

    String getMessage() {
        return this.message;
    }

    String getAuthor() {
        return this.author;
    }

    void setMessage(String message) {
        this.message= message;
    }
    

    void setAuthor(String author) {
        this.author = author;
    }
    
}
