package PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Controller;

import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Project;
import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Register;

import java.util.List;

public class MessageBuilderProjects extends MessageBuilder {

    /** =================    =================    Projects messages    =================   ================= */

    // Message for projects main menu
    public String chooseOptionForProject(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("You have ")
                .append(amountOfProjectsToDo(register)).append(" project");         // Amount of unfinished projects
        if (amountOfProjectsToDo(register) != 1)
            builtMessage.append("s");
        builtMessage.append(" to do and ")
                .append(amountOfProjectsDone(register)).append(" project");         // Amount of finished projects
        if (amountOfProjectsDone(register) != 1)
            builtMessage.append("s");
        builtMessage.append(" finished").append("\n\nChoose an option")             // Main choice for projects
                .append("\n\n(1) Filter projects (by assignment or status)")
                .append("\n(2) Show projects (sorted by title, Id, due date, amount of tasks)")
                .append("\n(3) Add new project")
                .append("\n(4) Edit project (update, mark as finished, remove)")
                .append("\n(5) Back to main menu");
        return String.valueOf(builtMessage);
    }

    // Edit activities menu for projects
    public String chooseActivityForProject(Register register, String chosenProject) {
        String builtMessage = "Choose activity for " + chosenProject + " (" +
                register.findProject(chosenProject).getTitle() + ")" +
                "\n\n(1) Update (title, due date, assign tasks, status)" +
                "\n(2) Mark as finished" +
                "\n(3) Remove" +
                "\n(4) Back to main menu";
        return builtMessage;
    }

    // Update fields possibilities menu for projects (with actual values printed)
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

    // Choices
    public String ifAddNextTask() {
        return "Choose an option" + "\n\n(1) Add next task" + "\n(2) Go to main menu";
    }

    public String enterProjectTitle() { return  "Enter project title"; }

    public String chooseProjectsSorting() {
        return  "Print projects sorted by \n\n(1) Title \n(2) Id \n(3) Due date \n(4) Amount of tasks";
    }

    // Confirmations
    public String removeProjectConfirmation() { return "Project was removed from the register"; }

    public String markProjectAsDoneConfirmation() { return "Project was marked as finished"; }

    public String fixProjectStatusConfirmation() { return  "Project status was fixed"; }

    public String changedProjectDueDateConfirmation() { return  "Project due date was changed"; }

    public String changedProjectTitleConfirmation() { return  "Project title was changed"; }

    public String addedProjectConfirmation(Register register) {
        return "New project was added as " + register.getProjects().get(register.getProjects().size() - 1).getId();
    }

    // Print out for filtered or sorted projects
    public String listOfProjects(List<Project> projects) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Projects\n");
        projects.forEach(project -> builtMessage.append(addProjectToListForMain(project)));   // Add projects to list
        return String.valueOf(builtMessage);
    }
}
