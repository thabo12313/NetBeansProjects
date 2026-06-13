/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agevalidation;

/**
 *
 * @author thabo
 */
public class AgeValidator {
    //method to check age validation
    public void validateAge(int age){
        if (age<18){
            throw new InvalidAgeException ("You must be 18 or above.");
        } else {
        System.out.println("Age is valid for registration!");
        }
    }
    
}
