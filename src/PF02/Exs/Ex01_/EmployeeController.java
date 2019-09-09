package PF02.Exs.Ex01_;

public class EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void printEeDetails() { view.printDetails(model); }

    public void updateName(String newName){ model.setName(newName); }

//    public void changeName(Employee employee, String newName){ employee.setName(newName); }

    public void updateSsn(String newSsn) { model.setSsn(newSsn); }

    public void updateSalaryPerHour(int newSalaryPerHour) { model.setSalaryPerHour(newSalaryPerHour); }

    public void increaseSalaryPerHour(int amount) { model.setSalaryPerHour(model.getSalaryPerHour() + amount); }

    public void decreaseSalaryPerHour(int amount) { model.setSalaryPerHour(model.getSalaryPerHour() - amount); }

    public void updateHoursWorked(int newHoursWorked) { model.setHoursWorked(newHoursWorked); }

    public void addHoursWorked(int hours) { model.setHoursWorked(model.getHoursWorked() + hours); }

    public void printEeMonthlySalary() { view.printMonthlySalary(model); }
}
