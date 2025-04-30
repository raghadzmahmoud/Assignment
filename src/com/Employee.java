package com;

public class Employee {
    private String name;
    private int age;
    private double salary;
    private String department;
    private String city;

    public Employee(String name, int age, double salary, String department, String city) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.city = city;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return name + " (" + age + " yrs, $" + salary + ", " + department + ", " + city + ")";
    }
}
