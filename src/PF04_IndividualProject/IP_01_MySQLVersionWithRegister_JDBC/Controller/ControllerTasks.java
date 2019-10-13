package PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Controller;

import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Register;
import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Task;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerTasks {
    private MessageBuilderTasks messageBuilderTasks = new MessageBuilderTasks();
    private PopUpsBuilderTasks popUpsBuilderTasks = new PopUpsBuilderTasks();

    public ControllerTasks() {
        this.setMessageBuilderTasks(new MessageBuilderTasks());
        this.setPopUpsBuilderTasks(new PopUpsBuilderTasks());
    }

    public MessageBuilderTasks getMessageBuilderTasks() { return messageBuilderTasks; }
    public PopUpsBuilderTasks getPopUpsBuilderTasks() { return popUpsBuilderTasks; }

    public void setMessageBuilderTasks(MessageBuilderTasks messageBuilderTasks) { this.messageBuilderTasks = messageBuilderTasks; }
    public void setPopUpsBuilderTasks(PopUpsBuilderTasks popUpsBuilderTasks) { this.popUpsBuilderTasks = popUpsBuilderTasks; }

    /** =================    =================    Controller for tasks    =================   ================= */

    // Main program for tasks
    public void run(Register register) {
        optionChoice(register);                         // Start with tasks
    }

    // Main menu for tasks, first choice
    private void optionChoice(Register register) {
        int optionChosen = -1;
        while (optionChosen < 0 || optionChosen > 4)
            optionChosen = getPopUpsBuilderTasks().chooseOptionForTask(register);

        switch (optionChosen) {
            case 0:                                     // Back to main menu of application
                break;
            case 1:                                     // Edit task
                editTaskChosen(register);
                break;
            case 2:                                     // Add new task
                addNewTaskChosen(register);
                break;
            case 3:                                     // Print out sorted tasks
                printOutSortedChosen(register);
                break;
            case 4:                                     // Print out filtered tasks
                printOutFilteredOptionChosen(register);
                break;
        }
    }

    // Edit task was chosen
    private void editTaskChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderTasks().noTasksInfo();                                // Inform if there are no tasks
        } else {
            String chosenTask = chooseTaskToEdit(register);                       // Choose task to work with
            int chosenActivity = chooseActivityForTask(register, chosenTask);     // Choose what to do

            switch (chosenActivity) {
                case 0:                                                 // Back to main menu of application
                    break;
                case 1:                                                 // Remove task
                    removeTaskChosen(register, chosenTask);
                    break;
                case 2:                                                 // Mark task as done
                    markTaskAsDone(register, chosenTask);
                    break;
                case 3:                                                 // Edit one of fields of chosen task
                    chooseTaskFieldToEdit(register, chosenTask);
                    break;
            }
        }
    }

    // Choose task to work with
    private String chooseTaskToEdit(Register register) {
        String chosenTask;
        do {
            chosenTask = getPopUpsBuilderTasks().chooseTaskToEdit(register);            // Print popup with choices
        } while (!register.getTasksIds().contains(chosenTask));                         // Until task is chosen
        return chosenTask;
    }

    // Choose what to do
    private int chooseActivityForTask(Register register, String chosenTask) {
        int chosenActivity = -1;
        while (chosenActivity < 0 || chosenActivity > 3) {                              // Print popup with choices
            chosenActivity = getPopUpsBuilderTasks().chooseActivityForTask(register, chosenTask);
        }
        return chosenActivity;
    }

    // Remove task from register
    private void removeTaskChosen(Register register, String chosenTask) {
        register.removeTask(chosenTask);                                                // Remove task
        getPopUpsBuilderTasks().taskRemovalConfirmation();                              // Print confirmation
    }

    // Mark task as done
    private void markTaskAsDone(Register register, String chosenTask) {
        register.markTaskAsDone(chosenTask);                                            // Mark project as done
        getPopUpsBuilderTasks().taskMarkedAsDoneConfirmation();                         // Print confirmation
    }

    // Choose field which will be edited
    private void chooseTaskFieldToEdit(Register register, String chosenTask) {
        int chosenField = -1;
        while (chosenField < 0 || chosenField > 4) {                                    // Print popup with choices
            chosenField = getPopUpsBuilderTasks().chooseTaskFieldToEdit(register, chosenTask);

            switch (chosenField) {
                case 0:                                                         // Back to main menu of application
                    break;
                case 1:                                                         // Change status of chosen task
                    changeTaskStatus(register, chosenTask);
                    break;
                case 2:                                                         // Reassign task to project
                    assignToProject(register, chosenTask);
                    break;
                case 3:                                                         // Change due date of chosen task
                    changeTaskDueDate(register, chosenTask);
                    break;
                case 4:                                                         // Change title of chosen task
                    changeTaskTitle(register, chosenTask);
                    break;
            }
        }
    }

    // Change status of chosen task
    private void changeTaskStatus(Register register, String chosenTask) {
        int chosenStatus = chooseTaskStatus();                                  // Choose new status
        register.setTaskStatus(chosenTask, chosenStatus);                       // Change status of chosen task
        getPopUpsBuilderTasks().fixTaskStatusConfirmation();                    // Print confirmation
    }

    // Choose new status
    private int chooseTaskStatus() {
        int chosenStatus = -1;
        while (chosenStatus < 0 || chosenStatus > 1) {
            chosenStatus = getPopUpsBuilderTasks().chooseTaskStatus();           // Print popup with choices
        }
        return chosenStatus;
    }

    // Assign task to project
    private void assignToProject(Register register, String chosenTask) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderTasks().noProjectsInfo();                           // Inform if there are no projects
        } else {
            String chosenProjectToAssignTo = chooseProjectToAssignTo(register);         // Choose project to assign to
            assignTaskToTheProject(register, chosenTask, chosenProjectToAssignTo);      // Assign task to chosen project
        }
    }

    // Choose project to assign task to it
    private String chooseProjectToAssignTo(Register register) {
        String chosenProjectToAssignTo;
        do {
            do {                                                              // Print popup with choices
                chosenProjectToAssignTo = getPopUpsBuilderTasks().chooseProjectToAssignTo(register);
            } while (chosenProjectToAssignTo == null);
        } while (!register.getProjectsIds().contains(chosenProjectToAssignTo));
        return chosenProjectToAssignTo;
    }

    // Assign task to chosen project
    private void assignTaskToTheProject(Register register, String chosenTask, String chosenProjectToAssignTo) {
        if (!register.findTask(chosenTask).getAssignedToProject().equals(chosenProjectToAssignTo)) {
                                                                            // Assign task if it was not assigned
            register.findTask(chosenTask).setAssignedToProject(chosenProjectToAssignTo);                    // Mark in task
            register.addTaskToProject(chosenTask, chosenProjectToAssignTo);                                 // List in project
            getPopUpsBuilderTasks().addedTaskToProjectConfirmation(chosenTask, chosenProjectToAssignTo);    // Confirm
        } else {                                                            // Inform that it was assigned
            getPopUpsBuilderTasks().taskAlreadyInProjectInformation(chosenTask, chosenProjectToAssignTo);
        }
    }

    // Change due date of chosen task
    private void changeTaskDueDate(Register register, String chosenTask) {
        String chosenDueDate = "";
        DateValidator dateValidator = new DateValidator();
        do {
            do {
                do {
                    chosenDueDate = getPopUpsBuilderTasks().changeTaskDueDate();            // Ask for due date input
                } while (chosenDueDate == null);
            } while (chosenDueDate.equals(""));
        } while (!dateValidator.isThisDateValid(chosenDueDate, "yyyyMMdd"));     // Check if date is valid

        register.findTask(chosenTask).setDueDate(chosenDueDate);                    // Change due date of chosen task
        getPopUpsBuilderTasks().changeTaskDueDateConfirmation();                    // Print confirmation
    }

    // Change title of chosen task
    private void changeTaskTitle(Register register, String chosenTask) {
        String chosenTitle = chooseNewTitleForTask();                               // Get new title
        register.findTask(chosenTask).setTitle(chosenTitle);                        // Change title of chosen task
        getPopUpsBuilderTasks().changedTaskTitleConfirmation();                     // Print confirmation
    }

    // Get new title
    private String chooseNewTitleForTask() {
        String chosenTitle = "";
        do {
            do {
                chosenTitle = getPopUpsBuilderTasks().chooseNewTitleForTask();     // Ask for title input
            } while (chosenTitle == null);
        } while (chosenTitle.equals(""));
        return chosenTitle;
    }

    // Add new task
    private void addNewTaskChosen(Register register) {
        String newTitle = enterNewTitleForTask();                               // Get title
        String newDueDate = enterNewDueDateForTask();                           // Get due date
        register.addTask(new Task(newTitle, newDueDate));                       // Add new task to register
        getPopUpsBuilderTasks().addedNewTaskConfirmation(register);             // Print confirmation
    }

    // Get due date for new task
    private String enterNewDueDateForTask() {
        String newDueDate = "";
        DateValidator dateValidator = new DateValidator();
        do {
            do {
                do {
                    newDueDate = getPopUpsBuilderTasks().enterNewDueDateForTask();         // Ask for due date input
                } while (newDueDate == null);
            } while (newDueDate.equals(""));
        } while (!dateValidator.isThisDateValid(newDueDate, "yyyyMMdd"));       // Check if date is valid
        return newDueDate;
    }

    // Get title for new task
    private String enterNewTitleForTask() {
        String newTitle = "";
        do {
            do {
                newTitle = getPopUpsBuilderTasks().enterNewTitleForTask();                // Ask for title input
            } while (newTitle == null);
        } while (newTitle.equals(""));
        return newTitle;
    }

    // Print out sorted tasks
    private void printOutSortedChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderTasks().noTasksInfo();                                      // Inform if there are no tasks
        } else {
            int chosenSorting = chooseSortingForTasks();                                // Choose sorting

            List<Task> sortedTasks = null;
            switch (chosenSorting) {
                case 0:
                    sortedTasks = register.getTasks().stream()                          // Sort by project
                            .filter(task -> !task.getAssignedToProject().equals(""))
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparing(Task::getAssignedToProject)).collect(Collectors.toList());
                    break;

                case 1:
                    sortedTasks = register.getTasks().stream()                        // Sort by due date
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparing(Task::getDueDate)).collect(Collectors.toList());
                    break;

                case 2:
                    sortedTasks = register.getTasks().stream()                        // Sort by Id
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                    break;

                case 3:
                    sortedTasks = register.getTasks().stream()                        // Sort by title
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparing(Task::getTitle)).collect(Collectors.toList());
                    break;
            }
            getPopUpsBuilderTasks().printSortedTasks(sortedTasks);                    // Print out sorted list
        }
    }

    // Choose sorting
    private int chooseSortingForTasks() {
        int chosenSorting = -1;
        while (chosenSorting < 0 || chosenSorting > 3) {
            chosenSorting = getPopUpsBuilderTasks().chooseSortingForTasks();        // Print popup with choices
        }
        return chosenSorting;
    }

    // Print out filtered tasks
    private void printOutFilteredOptionChosen(Register register) {
        if (register.getTasks().size() == 0) {
            getPopUpsBuilderTasks().noTasksInfo();                                  // Inform if there are no tasks
        } else {
            int chosenFiltering = chooseFilteringForTasks();                        // Choose filtering

            List<Task> filteredTasks = null;
            switch (chosenFiltering) {
                case 0:
                    filteredTasks = register.getTasks().stream()                    // Filter unfinished
                            .filter(task -> !task.ifDone())
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                break;

                case 1:
                    filteredTasks = register.getTasks().stream()                    // Filter finished
                            .filter(Task::ifDone)
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                    break;

                case 2:
                    filteredTasks = register.getTasks().stream()                    // Filter not assigned
                            .filter(task -> task.getAssignedToProject().equals(""))
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                    break;

                case 3:
                    String chosenProject = "";                                      // Choose project
                    if (register.getProjects().size() != 0) {
                        do {
                            do {                                                    // Print popup with choices
                                chosenProject = getPopUpsBuilderTasks().chooseProjectForFiltering(register);
                            } while (chosenProject == null);
                        } while (!register.getProjectsIds().contains(chosenProject));

                    } else {
                        getPopUpsBuilderTasks().noProjectsInfo();                   // Inform if there are no projects
                    }

                    String finalChosenProject = chosenProject;
                    filteredTasks = register.getTasks().stream()                    // Filter by project assignment
                            .filter(task -> task.getAssignedToProject().equals(finalChosenProject))
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                    break;
            }
            getPopUpsBuilderTasks().printFilteredTasks(filteredTasks);              // Print out filtered list
        }
    }

    // Choose filtering
    private int chooseFilteringForTasks() {
        int chosenFiltering = -1;
        while (chosenFiltering < 0 || chosenFiltering > 3) {
            chosenFiltering = getPopUpsBuilderTasks().chooseFilteringForTasks();    // Print popup with choices
        }
        return chosenFiltering;
    }
}
