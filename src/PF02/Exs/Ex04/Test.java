package PF02.Exs.Ex04;

public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("750218-4624", "Per", new Student(), new Course());
        Student student = new Student("900314-6756", "Jan", teacher);
        teacher.setTutorOf(student);
        System.out.println(teacher.getName() + " with ssn " + teacher.getSsn() + " is a tutor for " +
                teacher.getTutorOf().getName() + " whose ssn is " + student.getSsn() + ".\n" +
                student.getName() + "'s tutor is " + student.getTutor().getName() + ", of course.");

        Car car = new Car("JFH 536", "Opel", new Owner());
        Owner owner = new Owner("900314-6756", "Jan", car);
        car.setOwner(owner);
        System.out.println(owner.getName() + " with ssn " + owner.getSsn() + " is an owner of " +
                owner.getOwnerOf().getModel() + " whose plates are " + car.getRegNr() + ".\n" +
                car.getModel() + "'s owner is " + car.getOwner().getName() + ", of course.");

        Person person = new Person("750218-4624", "Per", new Account());
        Account account = new Account("42-90314-67", person);
        person.setHolderOf(account);
        System.out.println(person.getName() + " with ssn " + person.getSsn() + " is a holder of the account " +
                person.getHolderOf().getAccountNr() + ".\n" +
                "Owner of the account " + account.getAccountNr() + " is " + account.getHolder().getName() + ", of course.");

        Course course = new Course("M326-Z19", "MathFundamentals", teacher);
        teacher.setResponsibleFor(course);
        System.out.println(teacher.getName() + " is responsible for course number " +
                teacher.getResponsibleFor().getCourseId() + ".\n" +
                "Responsible for the course " + course.getName() + " is " + course.getResponsible().getName() + ", of course.");

    }
}
