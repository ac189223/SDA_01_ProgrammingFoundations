package PF02.Exs;

import java.util.ArrayList;

public class Ex06_EmployeeReg {
    private static ArrayList<Ex06_Employee> employeesReg = new ArrayList<>();

    public Ex06_EmployeeReg(ArrayList<Ex06_Employee> employeesReg) { this.employeesReg = employeesReg; }

    public ArrayList<Ex06_Employee> getEmployeesReg() { return employeesReg; }

    public void setEmployeesReg(ArrayList<Ex06_Employee> employeesReg) { this.employeesReg = employeesReg; }

    public void addEmployee(Ex06_Employee employee) { getEmployeesReg().add(employee); }

    public void addListEes(ArrayList<Ex06_Employee> listEes) { for (Ex06_Employee employee: listEes) getEmployeesReg().add(employee); }

    public void printEmployees() { for (Ex06_Employee employee: getEmployeesReg())
            System.out.println(employee.getName() + " earns " + employee.getSalary() + ", "); }

    public void countEmployees() { System.out.println( "We have " + getEmployeesReg().size() + " employees, for today"); }

    public void highSalaryEmployees() {
        String output = "";
        for (Ex06_Employee employee: getEmployeesReg())
            if (employee.getSalary() > 14000)
                output += employee.getName() + ", ";
        System.out.println(output.substring(0, output.length() - 2) + " earn more than 14000");
    }

    public void countHighSalaryEmployees() {
        int output = 0;
        for (Ex06_Employee employee: getEmployeesReg())
            if (employee.getSalary() > 14000)
                output++;
        System.out.println(output + " employees earn more than 14000");
    }

    public void totalSalary() {
        int sum = 0;
        for (Ex06_Employee employee: getEmployeesReg())
            sum += employee.getSalary();
        System.out.println("Together our employees earn " + sum + " monthly");
    }

    public static void main(String[] args) {
        Ex06_EmployeeReg Ees = new Ex06_EmployeeReg(new ArrayList<>());
        ArrayList<Ex06_Employee> tmpEes = new ArrayList<>();

        Ees.addEmployee(new Ex06_Employee("Anna", 15000));
        Ees.addEmployee(new Ex06_Employee("Lars", 14000));
        Ees.addEmployee(new Ex06_Employee("Eva", 16000));
        Ees.countEmployees();
        Ees.printEmployees();
        System.out.println();

        tmpEes.add(new Ex06_Employee("Karl", 19000));
        tmpEes.add(new Ex06_Employee("Malin", 12000));
        tmpEes.add(new Ex06_Employee("Johannes", 15000));
        Ees.addListEes(tmpEes);
        Ees.countEmployees();
        Ees.printEmployees();
        System.out.println();

        Ees.countHighSalaryEmployees();
        Ees.highSalaryEmployees();
        Ees.totalSalary();
    }
}
/*
1.Create a class EmployeeReg
 2.Create method AddEmployee (Employee aEmployee)
 3. The following shall be added to the list (Create a method): 
Anna 15000 
Lars 14000 
Eva 16000
4.Create a method that prints the names of all employees who earn more than 14000 
5.Create a method that prints the number of employees earning more than 14000 
6.Create a method that prints the total of all employee wages
 */
