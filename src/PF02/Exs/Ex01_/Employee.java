package PF02.Exs.Ex01_;

public class Employee {
    private String name;
    private String ssn;
    private int salaryPerHour;
    private int hoursWorked;

    public Employee(String name, String ssn, int salaryPerHour, int hoursWorked) {
        this.name = name;
        this.ssn = ssn;
        this.salaryPerHour = salaryPerHour;
        this.hoursWorked = hoursWorked;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSsn() { return ssn; }

    public void setSsn(String ssn) { this.ssn = ssn; }

    public int getSalaryPerHour() { return salaryPerHour; }

    public void setSalaryPerHour(int salaryPerHour) { this.salaryPerHour = salaryPerHour; }

    public int getHoursWorked() { return hoursWorked; }

    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }
}
 /*
 Implement the class Employee.
All instance variables must be private and have public access methods.
The attributes name and ssn (social security number) must be declared asObjects of the String class.
The attributes salaryPerHour and hoursWorked must be declared as int.
The method monthlySalary() is calculated by multiplying instance variables salaryPerHour and hoursWorked

Implement also a test method (main method) to test all the methods of the class Employee.
  */