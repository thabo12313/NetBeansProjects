/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankexception;

/**
 *
 * @author thabo
 */
public class BankException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BankAccount account = new BankAccount(500);
        
        try{
        account.withdraw(600);
        } catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }
    }
    
}
