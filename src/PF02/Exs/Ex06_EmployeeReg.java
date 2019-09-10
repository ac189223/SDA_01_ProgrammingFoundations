package PF02.Exs;

import java.util.ArrayList;

public class Ex06_EmployeeReg {
    ArrayList<Ex06_Employee> employeesReg = new ArrayList<>();

    public Ex06_EmployeeReg(ArrayList<Ex06_Employee> employeesReg) { this.employeesReg = employeesReg; }

    public ArrayList<Ex06_Employee> getEmployeesReg() { return employeesReg; }

    public void setEmployeesReg(ArrayList<Ex06_Employee> employeesReg) { this.employeesReg = employeesReg; }

    public void addEmployee(Ex06_Employee employee) { getEmployeesReg().add(employee); }



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
