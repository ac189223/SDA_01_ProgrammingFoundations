package PF02.Exs;

public class Ex06_Employee {
    String name;
    double salary;

    public Ex06_Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }
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
