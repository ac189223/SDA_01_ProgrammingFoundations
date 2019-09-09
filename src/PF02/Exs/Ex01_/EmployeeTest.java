package PF02.Exs.Ex01_;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeView view = new EmployeeView();
        Employee employee = new Employee("Frank", "8005243587", 150, 176);
        EmployeeController emp1 = new EmployeeController(employee, view);

        emp1.printEeDetails();

        emp1.updateName("Jonathan");
        emp1.updateSsn("8204256548");
        emp1.updateSalaryPerHour(180);
        emp1.printEeDetails();

        emp1.increaseSalaryPerHour(30);
        emp1.updateHoursWorked(169);
        emp1.printEeDetails();

        emp1.decreaseSalaryPerHour(20);
        emp1.addHoursWorked(4);
        emp1.printEeDetails();

        emp1.printEeMonthlySalary();
    }
}
