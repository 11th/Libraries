package com.eleventh;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);

        employeeBook.create("Иванов Иван Иванович", "1", 200000);
        employeeBook.create("Сидоров Иван Иванович", "1", 15000);
        employeeBook.create("Фомин Иван Иванович", "1", 15000.2);
        employeeBook.create("Петров Иван Иванович", "2", 50000);
        employeeBook.create("Пупкин Василий Иванович", "3", 22000);

        System.out.println("\n//////////////////////////////////");

        System.out.println("\nВсе сотрудники");
        System.out.println(employeeBook);

        System.out.println("\nФИО");
        employeeBook.printEmployeesName();

        System.out.println("\nУдалить сотрудника с id 0");
        employeeBook.delete(0);
        System.out.println(employeeBook);

        System.out.println("\nСоздать нового");
        employeeBook.create("Иванов Иван Петрович", "5", 11000);
        System.out.println(employeeBook);

        System.out.println("\nИзменить департамент сотрудника с id 3");
        employeeBook.change(3, "1");
        System.out.println(employeeBook.findEmployeeById(3));

        System.out.println("\nИзменить зп сотрудника с id 1");
        employeeBook.change(1, 33000);
        System.out.println(employeeBook.findEmployeeById(1));

        System.out.println("\n//////////////////////////////////");

        System.out.println("\nСумма затрат на зп в месяц");
        System.out.println(employeeBook.calculateExpensesPerMonth());

        System.out.println("\nМинимальная зп");
        System.out.println(employeeBook.findEmployeeWithMinSalary());

        System.out.println("\nМаксимальная зп");
        System.out.println(employeeBook.findEmployeeWithMaxSalary());

        System.out.println("\nСреднее значение зп");
        System.out.format("%.2f\n", employeeBook.calculateAverageSalary());

        System.out.println("\nУвеличить зп на 10% всем");
        employeeBook.increaseSalaryForAll(10);
        System.out.println(employeeBook);

        System.out.println("\nСотрудники с зп меньше 25000");
        employeeBook.printEmployeesWithSalaryLessThan(25000);

        System.out.println("\nСотрудники с зп больше 25000");
        employeeBook.printEmployeesWithSalaryMoreThan(25000);

        System.out.println("\n//////////////////////////////////");

        System.out.println("\nСотрудник с макс зп в департаменте 1");
        System.out.println(employeeBook.findEmployeeWithMaxSalaryInDep("1"));

        System.out.println("\nСотрудник с мин зп в департаменте 1");
        System.out.println(employeeBook.findEmployeeWithMinSalaryInDep("1"));

        System.out.println("\nСумма затрат на зп по департаменту 1");
        System.out.println(employeeBook.calculateExpensesPerMonthInDep("1"));

        System.out.println("\nСреднее значение зп в департаменте 1");
        System.out.format("%.2f\n", employeeBook.calculateAverageSalaryInDep("1"));

        System.out.println("\nУвеличение зп на 11% в департаменте 1");
        employeeBook.increaseSalaryInDep("1", 11);
        System.out.println(employeeBook);

        System.out.println("\nСотрудники департамента 1");
        employeeBook.printEmployeesInDep("1");

        System.out.println("\n//////////////////////////////////");

        System.out.println("\nДепартаменты");
        employeeBook.printDepartments();
    }
}