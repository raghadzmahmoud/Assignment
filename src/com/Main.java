package com;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alex", 34, 63000, "Engineering", "NewYork"),
            new Employee("Marina", 43, 100000, "Engineering", "NewYork"),
            new Employee("Hasan", 23, 50000, "Sales", "NewYork"),
            new Employee("Elizabeth", 22, 50000, "Sales", "NewYork"),
            new Employee("Kim", 60, 70000, "Finance", "NewYork"),
            new Employee("Safa", 56, 40000, "HR", "NewYork"),
            new Employee("Ahmad", 43, 60000, "HR", "NewYork"),
            new Employee("Merry", 32, 35000, "Production", "SanFransisco"),
            new Employee("Saeed", 54, 43000, "Production", "SanFransisco")
        );

        // 1. Employees in Sales department
        System.out.println("Employees in Sales:");
        employees.stream()
            .filter(e -> e.getDepartment().equalsIgnoreCase("Sales"))
            .forEach(e -> System.out.println(e.getName() + " - Age: " + e.getAge()));

        // 2. Employees earning more than 50000
        System.out.println("\nEmployees earning > $50,000:");
        employees.stream()
            .filter(e -> e.getSalary() > 50000)
            .forEach(e -> System.out.println(e.getName() + " - Salary: $" + e.getSalary()));

        // 3. Group by city
        System.out.println("\nEmployees grouped by city:");
        Map<String, List<Employee>> byCity = employees.stream()
            .collect(Collectors.groupingBy(Employee::getCity));
        byCity.forEach((city, list) -> {
            System.out.println(city + ":");
            list.forEach(e -> System.out.println("  - " + e.getName()));
        });

        // 4. Top 5 highest paid
        System.out.println("\nTop 5 highest paid employees:");
        employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .limit(5)
            .forEach(e -> System.out.println(e.getName() + " - $" + e.getSalary()));

        // 5. Average salary in Engineering
        double avgSalary = employees.stream()
            .filter(e -> e.getDepartment().equalsIgnoreCase("Engineering"))
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0);
        System.out.println("\nAverage salary in Engineering: $" + avgSalary);
    }
}
