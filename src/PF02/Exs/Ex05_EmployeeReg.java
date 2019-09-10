package PF02.Exs;

import java.util.ArrayList;

public class Ex05_EmployeeReg {
    private ArrayList<Ex05_Employee> employees;

    public Ex05_EmployeeReg(ArrayList<Ex05_Employee> employees) { this.employees = employees; }

    public ArrayList<Ex05_Employee> getEmployees() { return employees; }

    public void setEmployees(ArrayList<Ex05_Employee> employees) { this.employees = employees; }

    public void insert(Ex05_Employee employee) { getEmployees().add(employee); }

    public void printDetails(Ex05_Employee employee) {
        System.out.println(employee.getName() + ", " + employee.getSsn() + ", " + employee.getAddress());
        System.out.println();
    }

    public void printDetailsOfAll() {
        for (Ex05_Employee employee : employees) {
            System.out.println(employee.getName() + ", " + employee.getSsn() + ", " + employee.getAddress());
        }
        System.out.println();
    }

    public void delete(String ssn) {
        boolean found = false;
        int i = 0;
        while (i < getEmployees().size() && !found) {
            if (getEmployees().get(i).getSsn().equals(ssn)) {
                getEmployees().remove(i);
                found = true;
            }
            i++;
        }
    }

    public Ex05_Employee find(String ssn) {
        Ex05_Employee employee = null;
        boolean found = false;
        int i = 0;
        while (i < getEmployees().size() && !found) {
            if (getEmployees().get(i).getSsn().equals(ssn)) {
                employee = getEmployees().get(i);
                found = true;
            }
            i++;
        }
        return employee;
    }

    public void newAddress(String ssn, String newAddress) {
        boolean found = false;
        int i = 0;
        while (i < getEmployees().size() && !found) {
            if (getEmployees().get(i).getSsn().equals(ssn)) {
                getEmployees().get(i).setAddress(newAddress);
                found = true;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Ex05_EmployeeReg employeeReg = new Ex05_EmployeeReg(new ArrayList<>());
        ArrayList<Ex05_Employee> tempEmployees = new ArrayList<>();

        tempEmployees.add(new Ex05_Employee("860325-3452", "Peter", "Arlov"));
        tempEmployees.add(new Ex05_Employee("800115-8572", "Lena", "Arlov"));
        tempEmployees.add(new Ex05_Employee("840610-3347", "Hilda", "Lund"));

        employeeReg.setEmployees(tempEmployees);
        employeeReg.printDetailsOfAll();

        employeeReg.insert(new Ex05_Employee("741223-0328", "Jakob", "Malmo"));
        employeeReg.printDetailsOfAll();

        employeeReg.printDetails(employeeReg.find("860325-3452"));

        employeeReg.delete("840610-3347");
        employeeReg.newAddress("800115-8572", "Lomma");
        employeeReg.printDetailsOfAll();
    }
}
/*
Create the class Employee,
attributes: ssn, name and address 
Create a directory to the class; EmployeeReg
Create methods: 
Insert (Employee e) - Adds an employee to the register.
 delete (String id) - removes an employee from the register. 
find (String id): Employee - Find an employee from the register, if the employee's return null. 
newAddress (String id, String newAddress) - Updates the address of an employee  
*/