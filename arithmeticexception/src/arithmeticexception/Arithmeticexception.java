/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arithmeticexception;

/**
 *
 * @author thabo
 */
public class Arithmeticexception {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            int result = 10/0;
        } catch (ArithmeticException e) {
            System.out.println("An arithmetic exeption occured: " + e.getMessage());
        }
    }
    
}
