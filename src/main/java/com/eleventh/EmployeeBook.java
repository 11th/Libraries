package com.eleventh;

public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook(int employeeCount) {
        employees = new Employee[employeeCount];
    }

    public void create(String fullName, String department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                return;
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public void change(int id, String department) {
        var employee = findEmployeeById(id);
        if (employee != null) {
            employee.setDepartment(department);
        }
    }

    public void change(int id, double salary) {
        var employee = findEmployeeById(id);
        if (employee != null) {
            employee.setSalary(salary);
        }
    }

    public double calculateExpensesPerMonth() {
        return calculateExpensesPerMonth(employees);
    }

    public double calculateExpensesPerMonthInDep(String department) {
        return calculateExpensesPerMonth(findEmployeesByDepartment(department));
    }

    private double calculateExpensesPerMonth(Employee[] employees) {
        double expenses = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                expenses += employee.getSalary();
            }
        }
        return expenses;
    }

    public double calculateAverageSalary() {
        return calculateExpensesPerMonth() / countEmployees(employees);
    }

    public double calculateAverageSalaryInDep(String department) {
        return calculateExpensesPerMonthInDep(department) / countEmployees(findEmployeesByDepartment(department));
    }

    public void increaseSalaryForAll(int percent) {
        increaseSalary(employees, percent);
    }

    public void increaseSalaryInDep(String department, int percent) {
        increaseSalary(findEmployeesByDepartment(department), percent);
    }

    private void increaseSalary(Employee[] employees, int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                var newSalary = employee.getSalary() + (employee.getSalary() * percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee findEmployeeWithMinSalary() {
        return findEmployeeWithMinSalary(employees);
    }

    public Employee findEmployeeWithMinSalaryInDep(String department) {
        return findEmployeeWithMinSalary(findEmployeesByDepartment(department));
    }

    private Employee findEmployeeWithMinSalary(Employee[] employees) {
        Employee employee = findEmployeeFirst();
        if (employee != null) {
            for (Employee value : employees) {
                if (value != null && value.getSalary() < employee.getSalary()) {
                    employee = value;
                }
            }
        }
        return employee;
    }

    public Employee findEmployeeWithMaxSalary() {
        return findEmployeeWithMaxSalary(employees);
    }

    public Employee findEmployeeWithMaxSalaryInDep(String department) {
        return findEmployeeWithMaxSalary(findEmployeesByDepartment(department));
    }

    private Employee findEmployeeWithMaxSalary(Employee[] employees) {
        Employee employee = findEmployeeFirst();
        if (employee != null) {
            for (Employee value : employees) {
                if (value != null && value.getSalary() > employee.getSalary()) {
                    employee = value;
                }
            }
        }
        return employee;
    }

    public Employee[] findEmployeesByDepartment(String department) {
        Employee[] employeesInDep = new Employee[employees.length];
        int next = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment().equals(department)) {
                employeesInDep[next++] = employee;
            }
        }
        return employeesInDep;
    }

    public Employee[] findEmployeesWithSalaryMoreThan(double compareSalary) {
        Employee[] result = new Employee[employees.length];
        int next = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > compareSalary) {
                result[next++] = employee;
            }
        }
        return result;
    }

    public Employee[] findEmployeesWithSalaryLessThan(double compareSalary) {
        Employee[] result = new Employee[employees.length];
        int next = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < compareSalary) {
                result[next++] = employee;
            }
        }
        return result;
    }

    public Employee findEmployeeFirst() {
        for (Employee employee : employees) {
            if (employee != null) {
                return employee;
            }
        }
        return null;
    }

    public String[] findAllDepartments() {
        String[] departments = new String[employees.length];
        int next = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                boolean isExist = false;
                for (String department : departments) {
                    if (department != null && department.equals(employee.getDepartment())) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    departments[next++] = employee.getDepartment();
                }
            }
        }
        return departments;
    }

    private int countEmployees(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public void printEmployeesName() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void printEmployeesInDep(String department) {
        var employeesInDep = findEmployeesByDepartment(department);
        for (Employee employee : employeesInDep) {
            if (employee != null) {
                System.out.println("Сотрудник: " + employee.getId() + ", ФИО: " +
                        employee.getFullName() + ", З/п: " + employee.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(double compareSalary) {
        for (Employee employee : findEmployeesWithSalaryLessThan(compareSalary)) {
            if (employee != null) {
                System.out.println(employee.getFullName() + " " + employee.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryMoreThan(double compareSalary) {
        for (Employee employee : findEmployeesWithSalaryMoreThan(compareSalary)) {
            if (employee != null) {
                System.out.println(employee.getFullName() + " " + employee.getSalary());
            }
        }
    }

    public void printDepartments() {
        var departments = findAllDepartments();
        for (String department : departments) {
            if (department == null) {
                break;
            }
            System.out.println("Департамент " + department);
            var employeesInDep = findEmployeesByDepartment(department);
            for (Employee employee : employeesInDep) {
                if (employee != null) {
                    System.out.println(employee.getFullName() + " " + employee.getSalary());
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : employees) {
            if (employee != null) {
                stringBuilder.append(employee);
                stringBuilder.append("\n");
            }
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return stringBuilder.toString();
    }
}
