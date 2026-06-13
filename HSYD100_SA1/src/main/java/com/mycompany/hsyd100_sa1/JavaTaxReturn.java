/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hsyd100_sa1;

/**
 * 05HA2310394
 * @author thabo
 */
public class JavaTaxReturn {

   // Fields
    private String socialSecurityNumber;
    private String lastName;
    private String firstName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private double annualIncome;
    private String maritalStatus;
    private double taxLiability;

    // Constructor
    public JavaTaxReturn(String socialSecurityNumber, String lastName, String firstName,
                         String streetAddress, String city, String state, String zipCode,double annualIncome, 
                         String maritalStatus) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.annualIncome = annualIncome;
        this.maritalStatus = maritalStatus;

        // Calculate tax liability based on annual income and marital status
        calculateTaxLiability();
    }

    // Method to calculate tax liability
    private void calculateTaxLiability() {
        // Tax rates based on the table provided
        double taxRate = 0.00;
        if (maritalStatus.equalsIgnoreCase("Single")) {
            if (annualIncome == 20000) {
                taxRate = 0.15;
            } else if (annualIncome <=20001 & annualIncome <= 50000){
                taxRate = 0.22;
            } else if(annualIncome >= 50001){
                taxRate = 0.30;
            
            }
        } else {
            // Assuming "Married" for maritalStatus
            if (annualIncome <= 20000) {
                taxRate = 0.15;
            } else if (annualIncome >=20001 & annualIncome <= 50000) {
                taxRate = 0.20;
            } else if(annualIncome >=20001 & annualIncome <= 50000) {
                taxRate = 0.28;
        }
        }
        // Calculate tax liability
        taxLiability = annualIncome * taxRate;
    }

    // Method to display TaxReturn data
    public void display() {
        System.out.println("Social security number: " + socialSecurityNumber);
        System.out.println("Last name: " + lastName);
        System.out.println("First name: " + firstName);
        System.out.println("Street address: " + streetAddress);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip code: " + zipCode);
        System.out.println("Annual income: R" + annualIncome);
        System.out.println("Marital status: " + maritalStatus);
        System.out.println("Tax liability: R" + taxLiability);
    }

    // Example of usage
    public static void main(String[] args) {
        // Creating an instance of JavaTaxReturn
        JavaTaxReturn taxReturn = new JavaTaxReturn("563-45-6989", "Mhlongo", "Thabo",
                "123 Main St", "Bellville", "South Africa", "7530", 40000, "Single");

        // Displaying TaxReturn data
        taxReturn.display();
    }
}
