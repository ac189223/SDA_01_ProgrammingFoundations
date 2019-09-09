package PF02.Exs;

public class Ex01 {
    private String name;
    private String ssn;
    private int salaryPerHour;
    private int hoursWorked;

    public Ex01(String name, String ssn, int salaryPerHour, int hoursWorked) {
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

    public void increaseSalaryPerHour(int amount) { setSalaryPerHour(getSalaryPerHour() + amount); }

    public void decreaseSalaryPerHour(int amount) { setSalaryPerHour(getSalaryPerHour() - amount); }

    public void addHoursWorked(int hours) { setHoursWorked(getHoursWorked() + hours); }


    public void printDetails() {
        System.out.println(getName() + " social security number is " + getSsn() + ". " +
                "He worked " + getHoursWorked() + " hours for "+ getSalaryPerHour() + " SEK per hour.");
    }

    public void printMonthlySalary() {
        System.out.println(getName() + " earned " + (getHoursWorked() * getSalaryPerHour()) + " SEK this month.");
    }

    public static void main(String[] args) {
        Ex01 employee = new Ex01("Frank", "8005243587", 150, 176);

        employee.printDetails();

        employee.setName("Jonathan");
        employee.setSsn("8204256548");
        employee.setSalaryPerHour(180);
        employee.printDetails();

        employee.increaseSalaryPerHour(30);
        employee.setHoursWorked(169);
        employee.printDetails();

        employee.decreaseSalaryPerHour(20);
        employee.addHoursWorked(4);
        employee.printDetails();

        employee.printMonthlySalary();
    }
}
