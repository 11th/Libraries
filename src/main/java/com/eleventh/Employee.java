package com.eleventh;

public class Employee {
    private static int count;

    private final int id;
    private final String fullName;
    private String department;
    private double salary;

    public Employee(String fullName, String department, double salary) {
        this.id = count++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник: " + id + ", ФИО: " + fullName + ", Департамент: " + department + ", З/п: " + salary;
    }
}
