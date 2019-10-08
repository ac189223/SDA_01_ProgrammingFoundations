package PF04_IndividualProject.IP_01.Controller;

import PF04_IndividualProject.IP_01.Model.Project;
import PF04_IndividualProject.IP_01.Model.Register;
import PF04_IndividualProject.IP_01.Model.Task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerProjects {
    private static final String FILE_NAME = "src/PF04_IndividualProject/Resources/IPData.csv";
    private MessageBuilder messageBuilder;
    private PopUpsBuilder popUpsBuilder;

    public ControllerProjects() {
        this.setMessageBuilder(new MessageBuilder());
        this.setPopUpsBuilder(new PopUpsBuilder());
    }

    public MessageBuilder getMessageBuilder() { return messageBuilder; }
    public PopUpsBuilder getPopUpsBuilder() { return popUpsBuilder; }

    public void setMessageBuilder(MessageBuilder messageBuilder) { this.messageBuilder = messageBuilder; }
    public void setPopUpsBuilder(PopUpsBuilder popUpsBuilder) { this.popUpsBuilder = popUpsBuilder; }

    public void run(Register register) {
        /** Start with projects  -->  mainChosen == 1 */
        optionChoice(register);
    }

    private void optionChoice(Register register) {
        int optionChosen = -1;
        while (optionChosen < 0 || optionChosen > 4)
            optionChosen = getPopUpsBuilder().chooseOptionForProject(register);

        switch (optionChosen) {
            case 0:     // Back to main menu
                break;
            case 1:     // Edit project
                editProjectChosen(register);
                break;
            case 2:     // Add new task
                addNewProjectChosen(register);
                break;
            case 3:     // Print out sorted
                printOutSortedChosen(register);
                break;
            case 4:     // Print out filtered
                printOutFilteredOptionChosen(register);
                break;
        }
    }

    private void editProjectChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilder().noTasksInfo();
        } else {
            String chosenProject = chooseProjectToEdit(register);
            int chosenActivity = chooseActivityForProject(register, chosenProject);

            switch (chosenActivity) {
                case 0:     // Back to main menu
                    break;
                case 1:     // Remove task or project
                    removeProjectChosen(register, chosenProject);
                    break;
                case 2:     // Mark as done
                    markProjectAsDone(register, chosenProject);
                    break;
                case 3:     // Edit fields
                    chooseProjectFieldToEdit(register, chosenProject);
                    break;
            }
        }
    }

    private String chooseProjectToEdit(Register register) {
        String chosenTask;
        do {
            chosenTask = getPopUpsBuilder().chooseProjectToEdit(register);
        } while (!register.getProjectsIds().contains(chosenTask));
        return chosenTask;
    }

    private int chooseActivityForProject(Register register, String chosenProject) {
        int chosenActivity = -1;
        while (chosenActivity < 0 || chosenActivity > 3) {
            chosenActivity = getPopUpsBuilder().chooseActivityForProject(register, chosenProject);
        }
        return chosenActivity;
    }

    private void removeProjectChosen(Register register, String chosenProject) {
        register.removeProjectAlways(chosenProject);                            /** REMOVE PROJECT _ AND TASKS ????? */
        getPopUpsBuilder().projectRemovalConfirmation();
    }

    private void markProjectAsDone(Register register, String chosenProject) {
        register.markProjectAsDoneAlways(chosenProject);
        getPopUpsBuilder().projectMarkedAsDoneConfirmation();
    }

    private void chooseProjectFieldToEdit(Register register, String chosenProject) {
        int chosenField = -1;
        while (chosenField < 0 || chosenField > 4) {
            chosenField = getPopUpsBuilder().chooseProjectFieldToEdit(register, chosenProject);

            switch (chosenField) {
                case 0:     // Back to main menu
                    break;
                case 1:     // Change status
                    changeProjectStatus(register, chosenProject);
                    break;
                case 2:     // Reassign to project or assign tasks
                    assignNewTasksToProject(register, chosenProject);
                    break;
                case 3:     // Change due date
                    changeProjectDueDate(register, chosenProject);
                    break;
                case 4:     // Change title
                    changeProjectTitle(register, chosenProject);
                    break;
            }
        }
    }

    private void changeProjectStatus(Register register, String chosenProject) {
        int chosenStatus = chooseProjectStatus();
        register.setProjectStatus(chosenProject, chosenStatus);
        getPopUpsBuilder().fixProjectStatusConfirmation();
    }

    private int chooseProjectStatus() {
        int chosenStatus = -1;
        while (chosenStatus < 0 || chosenStatus > 1) {
            chosenStatus = getPopUpsBuilder().chooseProjectStatus();
        }
        return chosenStatus;
    }

    private void assignNewTasksToProject(Register register, String chosenProject) {
        if (register.getTasks().size() == 0) {
            getPopUpsBuilder().noTasksInfo();
        } else {
            boolean addNextTask = true;
            do {
                String chosenTaskToAddToProject = chooseTaskToAddToTheProject(register);
                addTaskToTheProject(register, chosenProject, chosenTaskToAddToProject);

                addNextTask = ifAddNextTaskToProject(addNextTask);

            } while (addNextTask);
        }
    }

    private String chooseTaskToAddToTheProject(Register register) {
        String chosenTaskToAddToProject;
        do {
            do {
                chosenTaskToAddToProject = getPopUpsBuilder().chooseTaskToAddToTheProject(register);
            } while (chosenTaskToAddToProject == null);
        } while (!register.getTasksIds().contains(chosenTaskToAddToProject));
        return chosenTaskToAddToProject;
    }

    private void addTaskToTheProject(Register register, String chosenProject, String chosenTaskToAddToProject) {
        if (!register.findTask(chosenTaskToAddToProject).getAssignedToProject().equals(chosenProject)) {
            register.findTask(chosenTaskToAddToProject).setAssignedToProject(chosenProject);
            register.addTaskToProject(chosenTaskToAddToProject, chosenProject);
            getPopUpsBuilder().addedTaskToProjectConfirmation(chosenTaskToAddToProject, chosenProject);
        } else {
            getPopUpsBuilder().taskAlreadyInProjectInformation(chosenTaskToAddToProject, chosenProject);
        }
    }

    private boolean ifAddNextTaskToProject(boolean addNextTask) {
        int ifAddNext = -1;
        while (ifAddNext < 0 || ifAddNext > 1) {
            ifAddNext = getPopUpsBuilder().ifAddNext();
        }
        if (ifAddNext == 0)
            addNextTask = false;
        return addNextTask;
    }

    private void changeProjectDueDate(Register register, String chosenProject) {
        String chosenDueDate = "";
        DateValidator dateValidator = new DateValidator();
        do {
            do {
                do {
                    chosenDueDate = getPopUpsBuilder().changeProjectDueDate();    // Ask for due date
                } while (chosenDueDate == null);
            } while (chosenDueDate.equals(""));
        } while (!dateValidator.isThisDateValid(chosenDueDate, "yyyyMMdd"));

        register.findProject(chosenProject).setDueDate(chosenDueDate);
        getPopUpsBuilder().changeDueDateConfirmation();
    }

    private void changeProjectTitle(Register register, String chosenProject) {
        String chosenTitle = chooseNewTitleForProject();
        register.findProject(chosenProject).setTitle(chosenTitle);
        getPopUpsBuilder().changedProjectTitleConfirmation();
    }

    private String chooseNewTitleForProject() {
        String chosenTitle = "";
        do {
            do {
                chosenTitle = getPopUpsBuilder().chooseNewTitleForProject();     // Ask for title
            } while (chosenTitle == null);
        } while (chosenTitle.equals(""));
        return chosenTitle;
    }

    private void addNewProjectChosen(Register register) {
        String newTitle = enterNewTitleForProject();
        String newDueDate = enterNewDueDateForProject();
        register.addProject(new Project(newTitle, newDueDate));
        getPopUpsBuilder().addedNewTaskConfirmation(register);
    }

    private String enterNewDueDateForProject() {
        String newDueDate = "";
        DateValidator dateValidator = new DateValidator();
        do {
            do {
                do {
                    newDueDate = getPopUpsBuilder().enterNewDueDateForProject();
                } while (newDueDate == null);
            } while (newDueDate.equals(""));
        } while (!dateValidator.isThisDateValid(newDueDate, "yyyyMMdd"));
        return newDueDate;
    }

    private String enterNewTitleForProject() {
        String newTitle = "";
        do {
            do {
                newTitle = getPopUpsBuilder().enterNewTitleForProject();
            } while (newTitle == null);
        } while (newTitle.equals(""));
        return newTitle;
    }

    private void printOutSortedChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilder().noProjectsInfo();
        } else {
            int chosenSorting = chooseSortingForProjects();

            List<Project> sortedProjects = null;
            switch (chosenSorting) {
                case 0:       // Sort by number of tasks
                    sortedProjects = register.getProjects();
                    for (int i = 0; i < sortedProjects.size(); i++) {                  // Use bubble sort
                        for (int j = 0; j < sortedProjects.size() - i - 1; j++) {
                            if((sortedProjects.get(j)).getAssignedTasks().size() >
                                    (sortedProjects.get(j + 1)).getAssignedTasks().size()) {
                                Collections.swap(sortedProjects, j, j + 1);
                            }
                        }
                    }
                    break;

                case 1:       // Sort by due date
                    sortedProjects = register.getProjects().stream()
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparing(Project::getDueDate)).collect(Collectors.toList());
                    break;

                case 2:        // Sort by Id
                    sortedProjects = register.getProjects().stream()
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                    break;

                case 3:
                    sortedProjects = register.getProjects().stream()        // Sort by title
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparing(Project::getTitle)).collect(Collectors.toList());
                    break;
            }
            getPopUpsBuilder().printSortedProjects(sortedProjects);
        }
    }

    private int chooseSortingForProjects() {
        int chosenSorting = -1;
        while (chosenSorting < 0 || chosenSorting > 3) {
            chosenSorting = getPopUpsBuilder().chooseSortingForProjects();
        }
        return chosenSorting;
    }

    private void printOutFilteredOptionChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilder().noProjectsInfo();
        } else {
            int chosenFiltering = chooseFilteringForProjects();

            List<Project> filteredProjects = null;
            switch (chosenFiltering) {
                case 0:
                    filteredProjects = register.getProjects().stream()        // Filter unfinished
                            .filter(task -> !task.ifDone())
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                    break;

                case 1:
                    filteredProjects = register.getProjects().stream()        // Filter finished
                            .filter(Project::ifDone)
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                    break;

                case 2:
                    filteredProjects = register.getProjects().stream()        // Filter without assigned tasks
                            .filter(project -> project.getAssignedTasks().size() == 0)
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                    break;

                case 3:
                    filteredProjects = register.getProjects().stream()        // Filter with assigned tasks
                            .filter(project -> project.getAssignedTasks().size() != 0)
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                    break;
            }
            getPopUpsBuilder().printFilteredProjects(filteredProjects);
        }
    }

    private int chooseFilteringForProjects() {
        int chosenFiltering = -1;
        while (chosenFiltering < 0 || chosenFiltering > 3) {
            chosenFiltering = getPopUpsBuilder().chooseFilteringForProjects();
        }
        return chosenFiltering;
    }


}
