package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.EmployeeService;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n========== EMPLOYEE MANAGEMENT SYSTEM ==========");
            System.out.println("1. Create Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Raise Salary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

            case 1:

                String option;

                do {

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Designation (Programmer/Manager/Tester): ");
                    String designation = sc.nextLine();

                    try {
                        service.createEmployee(name, age, designation);
                        System.out.println("Employee Added Successfully.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.print("Continue? (Y/N): ");
                    option = sc.nextLine();

                } while (option.equalsIgnoreCase("Y"));

                break;

            case 2:

                service.displayEmployees();

                break;

            case 3:

                service.raiseSalary();

                break;

            case 4:

                System.out.println("Thank You.");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice.");
            }

        }

    }

}