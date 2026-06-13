
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author thabo
 */
public class FinallyBlock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader reader = null;
        
        
        try{
            //Attemp opening a file
            reader = new BufferedReader(new FileReader("example.txt"));
            String FirstLine = reader.readLine();
            System.out.println("This is the first line in the file: " + FirstLine);
        } catch (IOException e){
            System.out.println("Error occured: " + e.getMessage());
        
        } finally {
            try {
                if (reader!=null){
                reader.close();
                System.out.println("File closed successfully");
                } 
            } catch (Exception e){
                    System.out.println("File failed to close : " + e.getMessage());
                    
                    }
        
        }
    
    
    }
        
        
        
}
    

