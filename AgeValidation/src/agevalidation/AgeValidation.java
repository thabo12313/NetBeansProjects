/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agevalidation;

/**
 *
 * @author thabo
 */
public class AgeValidation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AgeValidator validator = new AgeValidator();
        
        try {
        validator.validateAge(26);//should throw
        }catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }
    }
    
}
