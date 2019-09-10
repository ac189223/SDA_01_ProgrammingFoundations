package PF02.Exs;

public class Ex05_Employee {
    private String ssn;
    private String name;
    private String address;

    public Ex05_Employee(String ssn, String name, String address) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
    }

    public String getSsn() { return ssn; }

    public void setSsn(String ssn) { this.ssn = ssn; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }
}
/*
Create the class Employee,
attributes: SSN, name and address 
Create a directory to the class; EmployeeReg
Create methods: 
Insert (Employee e) - Adds an employee to the register.
 delete (String id) - removes an employee from the register. 
find (String id): Employee - Find an employee from the register, if the employee's return null. 
newAddress (String id, String newAddress) - Updates the address of an employee  
*/