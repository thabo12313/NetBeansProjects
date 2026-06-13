/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hsyd100_sa1;

/**
 * 05HA2310394
 * @author thabo
 */
public class CountLetterL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text = "Hello, World";
        char textL = 'l';
        int count = 0;
        
        for(int i = 0; i < text.length();i++){
            if(text.charAt(i) == textL){
                count++; 
        }
        
        }
        System.out.println("The letter L appears " + count + " times in Hello, World");
    }
    
}
