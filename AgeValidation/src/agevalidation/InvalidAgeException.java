/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agevalidation;

/**
 *
 * @author thabo
 */
public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException (String message){
    super(message);
    }
    
}
