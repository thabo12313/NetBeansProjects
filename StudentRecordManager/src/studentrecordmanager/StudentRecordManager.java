/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentrecordmanager;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author thabo
 */
public class StudentRecordManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Name of the file where records will be stored
        String fileName = "studentRecords.dat";

        try {
            // Open the random-access file in read-write mode ("rw")
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

            // Student record to write
            int studentID = 101;
            String studentName = "James Bond";

            // Write the student record to the file.
            // First, write the integer (Student ID)
            raf.writeInt(studentID);
            // Then, write the string (Student Name) using writeUTF
            raf.writeUTF(studentName);

            // To read the record back, set the file pointer to the beginning
            raf.seek(0);

            // Retrieve the student record from the file.
            int readID = raf.readInt();
            String readName = raf.readUTF();

            // Display the retrieved student record.
            System.out.println("Student ID: " + readID);
            System.out.println("Student Name: " + readName);

            // Close the file to release resources
            raf.close();
        } catch (IOException e) {
            System.err.println("An error occurred during file operations: " + e.getMessage());
        }
    }
    
}
