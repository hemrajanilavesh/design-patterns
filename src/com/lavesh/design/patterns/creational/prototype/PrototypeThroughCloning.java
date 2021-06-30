package com.lavesh.design.patterns.creational.prototype;


import java.util.ArrayList;
import java.util.List;

class Employees implements Cloneable {

    private static final int INITIAL_CAPACITY = 5;

    private List<String> employees;

    public Employees() {
        employees =   new ArrayList<>(INITIAL_CAPACITY);
        employees.add("A");
        employees.add("B");
        employees.add("C");
        employees.add("D");
    }

    public Employees(List<String> employees) {
        this.employees = employees;
    }

    public List<String> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        StringBuilder employeeNameBuilder = new StringBuilder();
        employeeNameBuilder.append("Employees->");
        for (String emp :
                this.employees) {
            employeeNameBuilder.append(emp).append(";");
        }
        return employeeNameBuilder.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        List<String> employees = new ArrayList<>(INITIAL_CAPACITY);

        for (String emp :
                this.employees) {
            employees.add(emp);
        }

        return new Employees(employees);
    }
}


public class PrototypeThroughCloning  {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employees employees = new Employees();
        Employees employees1 = (Employees) employees.clone();

        System.out.println(employees);
        System.out.println(employees1);

        employees1.getEmployees().add("E");

        System.out.println(employees);
        System.out.println(employees1);
    }

}
