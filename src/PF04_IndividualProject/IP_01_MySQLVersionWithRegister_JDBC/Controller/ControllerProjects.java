package PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Controller;

import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Project;
import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Register;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerProjects {
    private MessageBuilderProjects messageBuilderProjects;
    private PopUpsBuilderProjects popUpsBuilderProjects;

    public ControllerProjects() {
        this.setMessageBuilderProjects(new MessageBuilderProjects());
        this.setPopUpsBuilderProjects(new PopUpsBuilderProjects());
    }

    public MessageBuilderProjects getMessageBuilderProjects() { return messageBuilderProjects; }
    public PopUpsBuilderProjects getPopUpsBuilderProjects() { return popUpsBuilderProjects; }

    public void setMessageBuilderProjects(MessageBuilderProjects messageBuilderProjects) { this.messageBuilderProjects = messageBuilderProjects; }
    public void setPopUpsBuilderProjects(PopUpsBuilderProjects popUpsBuilderProjects) { this.popUpsBuilderProjects = popUpsBuilderProjects; }

    public void run(Register register) {
        /** Start with projects  -->  mainChosen == 1 */
        optionChoice(register);
    }

    private void optionChoice(Register register) {
        int optionChosen = -1;
        while (optionChosen < 0 || optionChosen > 4)
            optionChosen = getPopUpsBuilderProjects().chooseOptionForProject(register);

        switch (optionChosen) {
            case 0:     // Back to main menu
                break;
            case 1:     // Edit project
                editProjectChosen(register);
                break;
            case 2:     // Add new project
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
            getPopUpsBuilderProjects().noTasksInfo();
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
            chosenTask = getPopUpsBuilderProjects().chooseProjectToEdit(register);
        } while (!register.getProjectsIds().contains(chosenTask));
        return chosenTask;
    }

    private int chooseActivityForProject(Register register, String chosenProject) {
        int chosenActivity = -1;
        while (chosenActivity < 0 || chosenActivity > 3) {
            chosenActivity = getPopUpsBuilderProjects().chooseActivityForProject(register, chosenProject);
        }
        return chosenActivity;
    }

    private void removeProjectChosen(Register register, String chosenProject) {
        register.removeProjectAlways(chosenProject);                            /** REMOVE PROJECT _ AND TASKS ????? */
        getPopUpsBuilderProjects().projectRemovalConfirmation();
    }

    private void markProjectAsDone(Register register, String chosenProject) {
        register.markProjectAsDoneAlways(chosenProject);
        getPopUpsBuilderProjects().projectMarkedAsDoneConfirmation();
    }

    private void chooseProjectFieldToEdit(Register register, String chosenProject) {
        int chosenField = -1;
        while (chosenField < 0 || chosenField > 4) {
            chosenField = getPopUpsBuilderProjects().chooseProjectFieldToEdit(register, chosenProject);

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
        getPopUpsBuilderProjects().fixProjectStatusConfirmation();
    }

    private int chooseProjectStatus() {
        int chosenStatus = -1;
        while (chosenStatus < 0 || chosenStatus > 1) {
            chosenStatus = getPopUpsBuilderProjects().chooseProjectStatus();
        }
        return chosenStatus;
    }

    private void assignNewTasksToProject(Register register, String chosenProject) {
        if (register.getTasks().size() == 0) {
            getPopUpsBuilderProjects().noTasksInfo();
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
                chosenTaskToAddToProject = getPopUpsBuilderProjects().chooseTaskToAddToTheProject(register);
            } while (chosenTaskToAddToProject == null);
        } while (!register.getTasksIds().contains(chosenTaskToAddToProject));
        return chosenTaskToAddToProject;
    }

    private void addTaskToTheProject(Register register, String chosenProject, String chosenTaskToAddToProject) {
        if (!register.findTask(chosenTaskToAddToProject).getAssignedToProject().equals(chosenProject)) {
            register.findTask(chosenTaskToAddToProject).setAssignedToProject(chosenProject);
            register.addTaskToProject(chosenTaskToAddToProject, chosenProject);
            getPopUpsBuilderProjects().addedTaskToProjectConfirmation(chosenTaskToAddToProject, chosenProject);
        } else {
            getPopUpsBuilderProjects().taskAlreadyInProjectInformation(chosenTaskToAddToProject, chosenProject);
        }
    }

    private boolean ifAddNextTaskToProject(boolean addNextTask) {
        int ifAddNext = -1;
        while (ifAddNext < 0 || ifAddNext > 1) {
            ifAddNext = getPopUpsBuilderProjects().ifAddNext();
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
                    chosenDueDate = getPopUpsBuilderProjects().changeProjectDueDate();    // Ask for due date
                } while (chosenDueDate == null);
            } while (chosenDueDate.equals(""));
        } while (!dateValidator.isThisDateValid(chosenDueDate, "yyyyMMdd"));

        register.findProject(chosenProject).setDueDate(chosenDueDate);
        getPopUpsBuilderProjects().changeProjectDueDateConfirmation();
    }

    private void changeProjectTitle(Register register, String chosenProject) {
        String chosenTitle = chooseNewTitleForProject();
        register.findProject(chosenProject).setTitle(chosenTitle);
        getPopUpsBuilderProjects().changedProjectTitleConfirmation();
    }

    private String chooseNewTitleForProject() {
        String chosenTitle = "";
        do {
            do {
                chosenTitle = getPopUpsBuilderProjects().chooseNewTitleForProject();     // Ask for title
            } while (chosenTitle == null);
        } while (chosenTitle.equals(""));
        return chosenTitle;
    }

    private void addNewProjectChosen(Register register) {
        String newTitle = enterNewTitleForProject();
        String newDueDate = enterNewDueDateForProject();
        register.addProject(new Project(newTitle, newDueDate));
        getPopUpsBuilderProjects().addedNewProjectConfirmation(register);
    }

    private String enterNewDueDateForProject() {
        String newDueDate = "";
        DateValidator dateValidator = new DateValidator();
        do {
            do {
                do {
                    newDueDate = getPopUpsBuilderProjects().enterNewDueDateForProject();
                } while (newDueDate == null);
            } while (newDueDate.equals(""));
        } while (!dateValidator.isThisDateValid(newDueDate, "yyyyMMdd"));
        return newDueDate;
    }

    private String enterNewTitleForProject() {
        String newTitle = "";
        do {
            do {
                newTitle = getPopUpsBuilderProjects().enterNewTitleForProject();
            } while (newTitle == null);
        } while (newTitle.equals(""));
        return newTitle;
    }

    private void printOutSortedChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderProjects().noProjectsInfo();
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
            getPopUpsBuilderProjects().printSortedProjects(sortedProjects);
        }
    }

    private int chooseSortingForProjects() {
        int chosenSorting = -1;
        while (chosenSorting < 0 || chosenSorting > 3) {
            chosenSorting = getPopUpsBuilderProjects().chooseSortingForProjects();
        }
        return chosenSorting;
    }

    private void printOutFilteredOptionChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderProjects().noProjectsInfo();
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
            getPopUpsBuilderProjects().printFilteredProjects(filteredProjects);
        }
    }

    private int chooseFilteringForProjects() {
        int chosenFiltering = -1;
        while (chosenFiltering < 0 || chosenFiltering > 3) {
            chosenFiltering = getPopUpsBuilderProjects().chooseFilteringForProjects();
        }
        return chosenFiltering;
    }


}
