/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankexception;

/**
 *
 * @author thabo
 */
public class BankAccount {
    private double balance;
    
    public BankAccount(double balance){
    this.balance = balance;
    }
    
    //withdraw method which throws custom exception
    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount>balance){
            throw new InsufficientFundsException("You are broke to withdraw that kind of money!");
        }
        balance -=amount;
        System.out.println("Withdrawal successful! Remaining balance: R" + balance);
    
    }
    
}
