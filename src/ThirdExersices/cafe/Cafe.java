package ThirdExersices.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        int max = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getAge() > max) {
                max = employee.getAge();
            }
            if (employee.getAge() == max) {
                return employee;
            }
        }
        return null;
    }

    public Employee getEmployee(String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equals(name))
                .findFirst().get();
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
       sb.append( String.format("Employees working at Cafe %s:\n",name));
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
