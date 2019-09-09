package PF02.Exs.Ex01_;

public class EmployeeView {
    public void printDetails(Employee employee) {
        System.out.println(employee.getName() + " social security number is " + employee.getSsn() + ". " +
                "He worked " + employee.getHoursWorked() + " hours for "+ employee.getSalaryPerHour() + " SEK per hour.");
    }

    public void printMonthlySalary(Employee employee) {
        System.out.println(employee.getName() + " earned " + (employee.getHoursWorked() * employee.getSalaryPerHour()) + " SEK this month.");
    }
}
