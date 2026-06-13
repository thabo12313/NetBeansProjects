/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hsyd100_sa1;

/**
 * 05HA2310394
 * @author thabo
 */
public class CalculateSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] numbers = {5,10,15,25};
        int sum = 0;
        
        for (int number : numbers){
             sum += number;
        }
        System.out.println("The sum of numbers is " + sum);
    }
    
}
