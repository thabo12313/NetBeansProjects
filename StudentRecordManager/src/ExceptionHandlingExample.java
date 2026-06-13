
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author thabo
 */
public class ExceptionHandlingExample {

    /**
     * @param args the command line arguments
     */
    
    public static int divide (int numerator, int denominator) throws ArithmeticException {
        return numerator/denominator;
    
    }
    public static void main(String[] args) {
        //Prompt a use for input
        Scanner scanner = new Scanner(System.in);
        
        try {
            //user input
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();
            
            //user input
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();    
            
            int result = numerator/denominator;
            System.out.println("The result is : " + result);
            
            
        } catch (ArithmeticException e){
            //division by 0
            System.out.println("Error: Cannot divide: " + e.getMessage());
        } catch (Exception e){
            System.out.println("An unexpected error occured: "+ e.getMessage());
        } finally {
            //Ensuring the resource closes properly
            scanner.close();
            System.out.println("Resource scanner closed.");
        }
    }
    
}
