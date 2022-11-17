package com.eleventh;

import org.apache.commons.lang3.StringUtils;

public class Employee {
    private static final String ALPHABET = "[А-Яа-яЁё]+";

    private static int count;

    private final int id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String fullName;
    private String department;
    private double salary;

    public Employee(String lastName, String firstName, String middleNAme, String department, double salary) throws IllegalArgumentException {
        if (!StringUtils.isAlpha(lastName) || !StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(middleNAme)) {
            throw new IllegalArgumentException("400 - Bad request");
        }
        if ( !(lastName.matches(ALPHABET) && middleNAme.matches(ALPHABET) && firstName.matches(ALPHABET))) {
            throw new IllegalArgumentException("400 - Bad request");
        }
        this.id = count++;
        this.firstName = StringUtils.capitalize(firstName.toLowerCase().trim());
        this.middleName = StringUtils.capitalize(middleNAme.toLowerCase().trim());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase().trim());
        this.fullName = this.lastName + " " + this.firstName + " " + this.middleName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
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
