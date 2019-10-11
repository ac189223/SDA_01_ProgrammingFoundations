package PF04_IndividualProject.IP_01_MySQLVersion_JDBC.Controller;

import PF04_IndividualProject.IP_04_SplitControllerVersion.Model.Project;
import PF04_IndividualProject.IP_04_SplitControllerVersion.Model.Register;

import java.util.List;

public class MessageBuilderProjects extends MessageBuilder {

    /** =================    =================    Projects messages    =================   ================= */

    public String chooseOptionForProject(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("You have ").append(amountOfProjectsToDo(register)).append(" project");
        if (amountOfProjectsToDo(register) != 1)
            builtMessage.append("s");
        builtMessage.append(" to do and ").append(amountOfProjectsDone(register)).append(" project");
        if (amountOfProjectsDone(register) != 1)
            builtMessage.append("s");
        builtMessage.append(" finished").append("\n\nChoose an option")
                .append("\n\n(1) Filter projects (by assignment or status)")
                .append("\n(2) Show projects (sorted by title, Id, due date, amount of tasks)")
                .append("\n(3) Add new project")
                .append("\n(4) Edit project (update, mark as finished, remove)")
                .append("\n(5) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String chooseActivityForProject(Register register, String chosenTask) {
        String builtMessage = "Choose activity for " + chosenTask + " (" +
                register.findProject(chosenTask).getTitle() + ")" +
                "\n\n(1) Update (title, due date, status)" +
                "\n(2) Mark as finished" +
                "\n(3) Remove" +
                "\n(4) Back to main menu";
        return builtMessage;
    }

    public String removeProject() { return "Project was removed from the register"; }

    public String markProjectAsDone() { return "Project was marked as finished"; }

    public String chooseProjectField(Register register, String chosenTask) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Choose field to update for ").append(chosenTask)
                .append("\n\n(1) Title (").append(register.findProject(chosenTask).getTitle()).append(")")
                .append("\n(2) Due date (").append(register.findProject(chosenTask).getDueDate()).append(")")
                .append("\n(3) Assign tasks")
                .append("\n(4) Status");
        if (register.findProject(chosenTask).ifDone())
            builtMessage.append(" (finished)");
        else
            builtMessage.append(" (unfinished)");
        builtMessage.append("\n(5) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String fixProjectStatus() { return  "Project status was fixed"; }

    public String ifAddNextTask() {
        return "Choose an option" + "\n\n(1) Add next task" + "\n(2) Go to main menu";
    }

    public String changedProjectDueDate() { return  "Project due date was changed"; }

    public String changedProjectTitle() { return  "Project title was changed"; }

    public String enterProjectTitle() { return  "Enter project title"; }

    public String addedProject(Register register) {
        return "New project was added as " + register.getProjects().get(register.getProjects().size() - 1).getId();
    }

    public String chooseProjectsSorting() {
        String builtMessage = "";
        builtMessage = "Print projects sorted by" +
                "\n\n(1) Title" +
                "\n(2) Id" +
                "\n(3) Due date" +
                "\n(4) Amount of tasks";
        return builtMessage;
    }

    public String listOfProjects(List<Project> sortedProjects) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Projects\n");
        sortedProjects.forEach(project -> {        // Add tasks to string
            builtMessage.append("\n").append(project.getId());
            if (project.getAssignedTasks().size() != 0)  {
                if (project.getAssignedTasks().size() == 1)
                    builtMessage.append(" with ").append(project.getAssignedTasks().size()).append(" task");
                else
                    builtMessage.append(" with ").append(project.getAssignedTasks().size()).append(" tasks");
            }
            builtMessage.append(" - named \"").append(project.getTitle()).append("\", with due date ").append(project.getDueDate());
            if (project.ifDone())
                builtMessage.append(" - finished");
            else
                builtMessage.append(" - unfinished");
        });
        return String.valueOf(builtMessage);
    }
}
