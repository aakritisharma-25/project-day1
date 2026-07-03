package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public void createEmployee(String name, int age, String designation) {

        double salary = 0;

        switch (designation.toLowerCase()) {

        case "programmer":
            salary = 30000;
            designation = "Programmer";
            break;

        case "manager":
            salary = 50000;
            designation = "Manager";
            break;

        case "tester":
            salary = 25000;
            designation = "Tester";
            break;

        default:
            throw new RuntimeException("Invalid Designation");
        }

        employees.add(new Employee(name, age, designation, salary));
    }

    public void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Found.");
            return;
        }

        System.out.println();

        for (Employee emp : employees) {

            System.out.println("-------------------------------");
            System.out.println("Name        : " + emp.getName());
            System.out.println("Age         : " + emp.getAge());
            System.out.println("Designation : " + emp.getDesignation());
            System.out.println("Salary      : " + emp.getSalary());
        }

    }

    public void raiseSalary() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Available.");
            return;
        }

        for (Employee emp : employees) {

            switch (emp.getDesignation()) {

            case "Manager":
                emp.setSalary(emp.getSalary() * 1.20);
                break;

            case "Programmer":
                emp.setSalary(emp.getSalary() * 1.10);
                break;

            case "Tester":
                emp.setSalary(emp.getSalary() * 1.05);
                break;
            }
        }

        System.out.println("Salary Updated Successfully.");

    }

}