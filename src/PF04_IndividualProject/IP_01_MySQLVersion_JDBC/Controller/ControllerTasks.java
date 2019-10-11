package PF04_IndividualProject.IP_01_MySQLVersion_JDBC.Controller;

import PF04_IndividualProject.IP_04_SplitControllerVersion.Model.Register;
import PF04_IndividualProject.IP_04_SplitControllerVersion.Model.Task;

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

    public void run(Register register) {
        /** Start with projects  -->  mainChosen == 2 */
        optionChoice(register);
    }

    private void optionChoice(Register register) {
        int optionChosen = -1;
        while (optionChosen < 0 || optionChosen > 4)
            optionChosen = getPopUpsBuilderTasks().chooseOptionForTask(register);

        switch (optionChosen) {
            case 0:     // Back to main menu
                break;
            case 1:     // Edit task
                editTaskChosen(register);
                break;
            case 2:     // Add new task
                addNewTaskChosen(register);
                break;
            case 3:     // Print out sorted
                printOutSortedChosen(register);
                break;
            case 4:     // Print out filtered
                printOutFilteredOptionChosen(register);
                break;
        }
    }

    private void editTaskChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderTasks().noTasksInfo();
        } else {
            String chosenTask = chooseTaskToEdit(register);
            int chosenActivity = chooseActivityForTask(register, chosenTask);

            switch (chosenActivity) {
                case 0:     // Back to main menu
                    break;
                case 1:     // Remove task
                    removeTaskChosen(register, chosenTask);
                    break;
                case 2:     // Mark as done
                    markTaskAsDone(register, chosenTask);
                    break;
                case 3:     // Edit fields
                    chooseTaskFieldToEdit(register, chosenTask);
                    break;
            }
        }
    }

    private String chooseTaskToEdit(Register register) {
        String chosenTask;
        do {
            chosenTask = getPopUpsBuilderTasks().chooseTaskToEdit(register);
        } while (!register.getTasksIds().contains(chosenTask));
        return chosenTask;
    }

    private int chooseActivityForTask(Register register, String chosenTask) {
        int chosenActivity = -1;
        while (chosenActivity < 0 || chosenActivity > 3) {
            chosenActivity = getPopUpsBuilderTasks().chooseActivityForTask(register, chosenTask);
        }
        return chosenActivity;
    }

    private void removeTaskChosen(Register register, String chosenTask) {
        register.removeTask(chosenTask);
        getPopUpsBuilderTasks().taskRemovalConfirmation();
    }

    private void markTaskAsDone(Register register, String chosenTask) {
        register.markTaskAsDone(chosenTask);
        getPopUpsBuilderTasks().taskMarkedAsDoneConfirmation();
    }

    private void chooseTaskFieldToEdit(Register register, String chosenTask) {
        int chosenField = -1;
        while (chosenField < 0 || chosenField > 4) {
            chosenField = getPopUpsBuilderTasks().chooseTaskFieldToEdit(register, chosenTask);

            switch (chosenField) {
                case 0:     // Back to main menu
                    break;
                case 1:     // Change status
                    changeTaskStatus(register, chosenTask);
                    break;
                case 2:     // Reassign to project
                    assignToProject(register, chosenTask);
                    break;
                case 3:     // Change due date
                    changeTaskDueDate(register, chosenTask);
                    break;
                case 4:     // Change title
                    changeTaskTitle(register, chosenTask);
                    break;
            }
        }
    }

    private void changeTaskStatus(Register register, String chosenTask) {
        int chosenStatus = chooseTaskStatus();
        register.setTaskStatus(chosenTask, chosenStatus);
        getPopUpsBuilderTasks().fixTaskStatusConfirmation();
    }

    private int chooseTaskStatus() {
        int chosenStatus = -1;
        while (chosenStatus < 0 || chosenStatus > 1) {
            chosenStatus = getPopUpsBuilderTasks().chooseTaskStatus();
        }
        return chosenStatus;
    }

    private void assignToProject(Register register, String chosenTask) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderTasks().noProjectsInfo();
        } else {
            String chosenProjectToAssignTo = chooseProjectToAssignTo(register);
            assignTaskToTheProject(register, chosenTask, chosenProjectToAssignTo);
        //    getPopUpsBuilderTasks().reassignedTaskConfirmation();
        }
    }

    private String chooseProjectToAssignTo(Register register) {
        String chosenProjectToAssignTo;
        do {
            do {
                chosenProjectToAssignTo = getPopUpsBuilderTasks().chooseProjectToAssignTo(register);
            } while (chosenProjectToAssignTo == null);
        } while (!register.getProjectsIds().contains(chosenProjectToAssignTo));
        return chosenProjectToAssignTo;
    }

    private void assignTaskToTheProject(Register register, String chosenTask, String chosenProjectToAssignTo) {
        if (!register.findTask(chosenTask).getAssignedToProject().equals(chosenProjectToAssignTo)) {
            register.findTask(chosenTask).setAssignedToProject(chosenProjectToAssignTo);
            register.addTaskToProject(chosenTask, chosenProjectToAssignTo);
            getPopUpsBuilderTasks().addedTaskToProjectConfirmation(chosenTask, chosenProjectToAssignTo);
        } else {
            getPopUpsBuilderTasks().taskAlreadyInProjectInformation(chosenTask, chosenProjectToAssignTo);
        }
    }

    private void changeTaskDueDate(Register register, String chosenTask) {
        String chosenDueDate = "";
        DateValidator dateValidator = new DateValidator();
        do {
            do {
                do {
                    chosenDueDate = getPopUpsBuilderTasks().changeTaskDueDate();    // Ask for due date
                } while (chosenDueDate == null);
            } while (chosenDueDate.equals(""));
        } while (!dateValidator.isThisDateValid(chosenDueDate, "yyyyMMdd"));

        register.findTask(chosenTask).setDueDate(chosenDueDate);
        getPopUpsBuilderTasks().changeTaskDueDateConfirmation();
    }

    private void changeTaskTitle(Register register, String chosenTask) {
        String chosenTitle = chooseNewTitleForTask();
        register.findTask(chosenTask).setTitle(chosenTitle);
        getPopUpsBuilderTasks().changedTaskTitleConfirmation();
    }

    private String chooseNewTitleForTask() {
        String chosenTitle = "";
        do {
            do {
                chosenTitle = getPopUpsBuilderTasks().chooseNewTitleForTask();     // Ask for title
            } while (chosenTitle == null);
        } while (chosenTitle.equals(""));
        return chosenTitle;
    }

    private void addNewTaskChosen(Register register) {
        String newTitle = enterNewTitleForTask();
        String newDueDate = enterNewDueDateForTask();
        register.addTask(new Task(newTitle, newDueDate));
        getPopUpsBuilderTasks().addedNewTaskConfirmation(register);
    }

    private String enterNewDueDateForTask() {
        String newDueDate = "";
        DateValidator dateValidator = new DateValidator();
        do {
            do {
                do {
                    newDueDate = getPopUpsBuilderTasks().enterNewDueDateForTask();
                } while (newDueDate == null);
            } while (newDueDate.equals(""));
        } while (!dateValidator.isThisDateValid(newDueDate, "yyyyMMdd"));
        return newDueDate;
    }

    private String enterNewTitleForTask() {
        String newTitle = "";
        do {
            do {
                newTitle = getPopUpsBuilderTasks().enterNewTitleForTask();
            } while (newTitle == null);
        } while (newTitle.equals(""));
        return newTitle;
    }

    private void printOutSortedChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderTasks().noProjectsInfo();
        } else {
            int chosenSorting = chooseSortingForTasks();

            List<Task> sortedTasks = null;
            switch (chosenSorting) {
                case 0:
                    sortedTasks = register.getTasks().stream()        // Sort by project
                            .filter(task -> !task.getAssignedToProject().equals(""))
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparing(Task::getAssignedToProject)).collect(Collectors.toList());
                    break;

                case 1:
                    sortedTasks = register.getTasks().stream()        // Sort by due date
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparing(Task::getDueDate)).collect(Collectors.toList());
                    break;

                case 2:
                    sortedTasks = register.getTasks().stream()        // Sort by Id
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                    break;

                case 3:
                    sortedTasks = register.getTasks().stream()        // Sort by title
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparing(Task::getTitle)).collect(Collectors.toList());
                    break;
            }
            getPopUpsBuilderTasks().printSortedTasks(sortedTasks);
        }
    }

    private int chooseSortingForTasks() {
        int chosenSorting = -1;
        while (chosenSorting < 0 || chosenSorting > 3) {
            chosenSorting = getPopUpsBuilderTasks().chooseSortingForTasks();
        }
        return chosenSorting;
    }

    private void printOutFilteredOptionChosen(Register register) {
        if (register.getTasks().size() == 0) {
            getPopUpsBuilderTasks().noTasksInfo();
        } else {
            int chosenFiltering = chooseFilteringForTasks();

            List<Task> filteredTasks = null;
            switch (chosenFiltering) {
                case 0:
                    filteredTasks = register.getTasks().stream()        // Filter unfinished
                            .filter(task -> !task.ifDone())
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                break;

                case 1:
                    filteredTasks = register.getTasks().stream()        // Filter finished
                            .filter(Task::ifDone)
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                    break;

                case 2:
                    filteredTasks = register.getTasks().stream()        // Filter not assigned
                            .filter(task -> task.getAssignedToProject().equals(""))
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                    break;

                case 3:
                    String chosenProject = "";        // Choose project
                    if (register.getProjects().size() != 0) {
                        do {
                            do {
                                chosenProject = getPopUpsBuilderTasks().chooseProjectForFiltering(register);
                            } while (chosenProject == null);
                        } while (!register.getProjectsIds().contains(chosenProject));

                    } else {
                        getPopUpsBuilderTasks().noProjectsInfo();
                    }

                    String finalChosenProject = chosenProject;
                    filteredTasks = register.getTasks().stream()        // Filter by project assignment
                            .filter(task -> task.getAssignedToProject().equals(finalChosenProject))
                            .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                    break;
            }
            getPopUpsBuilderTasks().printFilteredTasks(filteredTasks);
        }
    }

    private int chooseFilteringForTasks() {
        int chosenFiltering = -1;
        while (chosenFiltering < 0 || chosenFiltering > 3) {
            chosenFiltering = getPopUpsBuilderTasks().chooseFilteringForTasks();
        }
        return chosenFiltering;
    }
}
