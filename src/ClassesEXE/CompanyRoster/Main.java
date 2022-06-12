package ClassesEXE.CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] employeeInfo = scanner.nextLine().split(" ");

            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee = null;
            switch (employeeInfo.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (employeeInfo[4].matches("\\d+")) {
                        int age = Integer.parseInt(employeeInfo[4]);
                        employee = new Employee(name, salary, position, department, age);

                    } else {
                        String email = employeeInfo[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    String email = employeeInfo[4];
                    int age = Integer.parseInt(employeeInfo[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }
            employeeList.add(employee);
            boolean departmentExists = departmentList.stream().filter(dep -> dep.getName().equals(department)).count() >= 1;
            if (!departmentExists) {
                departmentList.add(new Department(department));
            }
            Department currentDepartment = departmentList.stream().filter(dep -> dep.getName().equals(department))
                    .findFirst().get();
            currentDepartment.getEmployeeList().add(employee);
        }
        Department highestPaidDepartment = departmentList.stream().max(Comparator.comparingDouble(e -> e.calculateAverage()))
                .get();
        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

        highestPaidDepartment.getEmployeeList().stream()
                .sorted((e1,e2) -> (int)(e2.getSalary() - e1.getSalary()))
                .forEach(System.out::println);
    }
}
