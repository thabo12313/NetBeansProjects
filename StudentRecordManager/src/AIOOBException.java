/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author thabo
 */
public class AIOOBException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            int [] numbers = {1, 2, 3, 4, 5};
            System.out.println("Access index of 5: " + numbers[8]);
        }catch (ArrayIndexOutOfBoundsException aoe){
            System.out.println("Error occured: " + aoe.getMessage());
        }
        System.out.println("Progam continues");
    }
    
}
