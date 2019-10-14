package PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Controller;

import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Project;
import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Register;

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

    /** =================    =================    Controller for projects    =================   ================= */

    // Main program for projects
    public void run(Register register) {
        optionChoice(register);                         // Start with projects
    }

    // Main menu for projects, first choice
    private void optionChoice(Register register) {
        int optionChosen = -1;
        while (optionChosen < 0 || optionChosen > 4)
            optionChosen = getPopUpsBuilderProjects().chooseOptionForProject(register);

        switch (optionChosen) {
            case 0:                                     // Back to main menu of application
                break;
            case 1:                                     // Edit project
                editProjectChosen(register);
                break;
            case 2:                                     // Add new project
                addNewProjectChosen(register);
                break;
            case 3:                                     // Print out sorted projects
                printOutSortedChosen(register);
                break;
            case 4:                                     // Print out filtered projects
                printOutFilteredOptionChosen(register);
                break;
        }
    }

    // Edit project was chosen
    private void editProjectChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderProjects().noProjectsInfo();                                // Inform if there are no projects
        } else {
            String chosenProject = chooseProjectToEdit(register);                       // Choose project to work with
            int chosenActivity = chooseActivityForProject(register, chosenProject);     // Choose what to do

            switch (chosenActivity) {
                case 0:                                                     // Back to main menu
                    break;
                case 1:                                                     // Remove project
                    removeProjectChosen(register, chosenProject);
                    break;
                case 2:                                                     // Mark project as done
                    markProjectAsDone(register, chosenProject);
                    break;
                case 3:                                                     // Edit one of fields of chosen project
                    chooseProjectFieldToEdit(register, chosenProject);
                    break;
            }
        }
    }

    // Choose project to work with
    private String chooseProjectToEdit(Register register) {
        String chosenProject;
        do {
            chosenProject = getPopUpsBuilderProjects().chooseProjectToEdit(register);      // Print popup with choices
        } while (!register.getProjectsIds().contains(chosenProject));                      // Until project is chosen
        return chosenProject;
    }

    // Choose what to do
    private int chooseActivityForProject(Register register, String chosenProject) {
        int chosenActivity = -1;
        while (chosenActivity < 0 || chosenActivity > 3) {                                // Print popup with choices
            chosenActivity = getPopUpsBuilderProjects().chooseActivityForProject(register, chosenProject);
        }
        return chosenActivity;
    }

    // Remove project from register
    private void removeProjectChosen(Register register, String chosenProject) {
        register.removeProjectAlways(chosenProject);                                    // Remove project
        getPopUpsBuilderProjects().projectRemovalConfirmation();                        // Print confirmation
    }

    // Mark project as done
    private void markProjectAsDone(Register register, String chosenProject) {
        register.markProjectAsDoneAlways(chosenProject);                                // Mark project as done
        getPopUpsBuilderProjects().projectMarkedAsDoneConfirmation();                   // Print confirmation
    }

    // Choose field which will be edited
    private void chooseProjectFieldToEdit(Register register, String chosenProject) {
        int chosenField = -1;
        while (chosenField < 0 || chosenField > 4) {                                    // Print popup with choices
            chosenField = getPopUpsBuilderProjects().chooseProjectFieldToEdit(register, chosenProject);

            switch (chosenField) {
                case 0:                                                     // Back to main menu of application
                    break;
                case 1:                                                     // Change status of chosen project
                    changeProjectStatus(register, chosenProject);
                    break;
                case 2:                                                     // Assign tasks to chosen project
                    assignNewTasksToProject(register, chosenProject);
                    break;
                case 3:                                                     // Change due date of chosen project
                    changeProjectDueDate(register, chosenProject);
                    break;
                case 4:                                                     // Change title of chosen project
                    changeProjectTitle(register, chosenProject);
                    break;
            }
        }
    }

    // Change status of chosen project
    private void changeProjectStatus(Register register, String chosenProject) {
        int chosenStatus = chooseProjectStatus();                           // Choose new status
        register.setProjectStatus(chosenProject, chosenStatus);             // Change status of chosen project
        getPopUpsBuilderProjects().fixProjectStatusConfirmation();          // Print confirmation
    }

    // Choose new status
    private int chooseProjectStatus() {
        int chosenStatus = -1;
        while (chosenStatus < 0 || chosenStatus > 1) {
            chosenStatus = getPopUpsBuilderProjects().chooseProjectStatus();                // Print popup with choices
        }
        return chosenStatus;
    }

    // Assign tasks to chosen project
    private void assignNewTasksToProject(Register register, String chosenProject) {
        if (register.getTasks().size() == 0) {
            getPopUpsBuilderProjects().noTasksInfo();                                       // Inform if there are no tasks
        } else {
            boolean addNextTask = true;
            do {
                String chosenTaskToAddToProject = chooseTaskToAddToTheProject(register);    // Choose task to add
                addTaskToTheProject(register, chosenProject, chosenTaskToAddToProject);     // Assign task to chosen project

                addNextTask = ifAddNextTaskToProject(addNextTask);                          // Ask if want to add next task

            } while (addNextTask);                                                          // Repeat while want to add next
        }
    }

    // Choose task to add to chosen project
    private String chooseTaskToAddToTheProject(Register register) {
        String chosenTaskToAddToProject;
        do {
            do {                                                                            // Print popup with choices
                chosenTaskToAddToProject = getPopUpsBuilderProjects().chooseTaskToAddToTheProject(register);
            } while (chosenTaskToAddToProject == null);
        } while (!register.getTasksIds().contains(chosenTaskToAddToProject));
        return chosenTaskToAddToProject;
    }

    // Assign tasks to chosen project
    private void addTaskToTheProject(Register register, String chosenProject, String chosenTaskToAddToProject) {
        if (!register.findTask(chosenTaskToAddToProject).getAssignedToProject().equals(chosenProject)) {
                                                                                        // Assign task if it was not assigned
            register.findTask(chosenTaskToAddToProject).setAssignedToProject(chosenProject);                      // Mark in task
            register.addTaskToProject(chosenTaskToAddToProject, chosenProject);                                   // List in project
            getPopUpsBuilderProjects().addedTaskToProjectConfirmation(chosenTaskToAddToProject, chosenProject);   // Confirm
        } else {                                                                        // Inform that it was assigned
            getPopUpsBuilderProjects().taskAlreadyInProjectInformation(chosenTaskToAddToProject, chosenProject);
        }
    }

    // Ask if want to add next task
    private boolean ifAddNextTaskToProject(boolean addNextTask) {
        int ifAddNext = -1;
        while (ifAddNext < 0 || ifAddNext > 1) {
            ifAddNext = getPopUpsBuilderProjects().ifAddNext();                             // Print popup with choices
        }
        if (ifAddNext == 0)                                                                 // If No
            addNextTask = false;
        return addNextTask;                                                                 // If Yes
    }

    // Change due date of chosen project
    private void changeProjectDueDate(Register register, String chosenProject) {
        String chosenDueDate = "";
        DateValidator dateValidator = new DateValidator();
        do {
            do {
                do {
                    chosenDueDate = getPopUpsBuilderProjects().changeProjectDueDate();      // Ask for due date input
                } while (chosenDueDate == null);
            } while (chosenDueDate.equals(""));
        } while (!dateValidator.isThisDateValid(chosenDueDate, "yyyyMMdd"));    // Check if date is valid

        register.findProject(chosenProject).setDueDate(chosenDueDate);                  // Change due date of chosen project
        getPopUpsBuilderProjects().changeProjectDueDateConfirmation();                  // Print confirmation
    }

    // Change title of chosen project
    private void changeProjectTitle(Register register, String chosenProject) {
        String chosenTitle = chooseNewTitleForProject();                                // Get new title
        register.findProject(chosenProject).setTitle(chosenTitle);                      // Change title of chosen project
        getPopUpsBuilderProjects().changedProjectTitleConfirmation();                   // Print confirmation
    }

    // Get new title
    private String chooseNewTitleForProject() {
        String chosenTitle = "";
        do {
            do {
                chosenTitle = getPopUpsBuilderProjects().chooseNewTitleForProject();     // Ask for title input
            } while (chosenTitle == null);
        } while (chosenTitle.equals(""));
        return chosenTitle;
    }

    // Add new project
    private void addNewProjectChosen(Register register) {
        String newTitle = enterNewTitleForProject();                                    // Get title
        String newDueDate = enterNewDueDateForProject();                                // Get due date
        register.addProject(new Project(newTitle, newDueDate));                         // Add new project to register
        getPopUpsBuilderProjects().addedNewProjectConfirmation(register);               // Print confirmation
    }

    // Get due date for new project
    private String enterNewDueDateForProject() {
        String newDueDate = "";
        DateValidator dateValidator = new DateValidator();
        do {
            do {
                do {
                    newDueDate = getPopUpsBuilderProjects().enterNewDueDateForProject();    // Ask for due date input
                } while (newDueDate == null);
            } while (newDueDate.equals(""));
        } while (!dateValidator.isThisDateValid(newDueDate, "yyyyMMdd"));       // Check if date is valid
        return newDueDate;
    }

    // Get title for new project
    private String enterNewTitleForProject() {
        String newTitle = "";
        do {
            do {
                newTitle = getPopUpsBuilderProjects().enterNewTitleForProject();          // Ask for title input
            } while (newTitle == null);
        } while (newTitle.equals(""));
        return newTitle;
    }

    // Print out sorted projects
    private void printOutSortedChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderProjects().noProjectsInfo();                                // Inform if there are no projects
        } else {
            int chosenSorting = chooseSortingForProjects();                             // Choose sorting

            List<Project> sortedProjects = null;
            switch (chosenSorting) {
                case 0:                                                                 // Sort by number of tasks
                    sortedProjects = register.getProjects();
                    for (int i = 0; i < sortedProjects.size(); i++) {                   // Use bubble sort
                        for (int j = 0; j < sortedProjects.size() - i - 1; j++) {
                            if((sortedProjects.get(j)).getAssignedTasks().size() >
                                    (sortedProjects.get(j + 1)).getAssignedTasks().size()) {
                                Collections.swap(sortedProjects, j, j + 1);
                            }
                        }
                    }
                    break;

                case 1:                                                                 // Sort by due date
                    sortedProjects = register.getProjects().stream()
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparing(Project::getDueDate)).collect(Collectors.toList());
                    break;

                case 2:                                                                // Sort by Id
                    sortedProjects = register.getProjects().stream()
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                    break;

                case 3:
                    sortedProjects = register.getProjects().stream()                   // Sort by title
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparing(Project::getTitle)).collect(Collectors.toList());
                    break;
            }
            getPopUpsBuilderProjects().printSortedProjects(sortedProjects);            // Print out sorted list
        }
    }

    // Choose sorting
    private int chooseSortingForProjects() {
        int chosenSorting = -1;
        while (chosenSorting < 0 || chosenSorting > 3) {
            chosenSorting = getPopUpsBuilderProjects().chooseSortingForProjects();    // Print popup with choices
        }
        return chosenSorting;
    }

    // Print out filtered projects
    private void printOutFilteredOptionChosen(Register register) {
        if (register.getProjects().size() == 0) {
            getPopUpsBuilderProjects().noProjectsInfo();                            // Inform if there are no projects
        } else {
            int chosenFiltering = chooseFilteringForProjects();                     // Choose filtering

            List<Project> filteredProjects = null;
            switch (chosenFiltering) {
                case 0:
                    filteredProjects = register.getProjects().stream()              // Filter unfinished
                            .filter(task -> !task.ifDone())
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                    break;

                case 1:
                    filteredProjects = register.getProjects().stream()              // Filter finished
                            .filter(Project::ifDone)
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                    break;

                case 2:
                    filteredProjects = register.getProjects().stream()              // Filter without assigned tasks
                            .filter(project -> project.getAssignedTasks().size() == 0)
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                    break;

                case 3:
                    filteredProjects = register.getProjects().stream()              // Filter with assigned tasks
                            .filter(project -> project.getAssignedTasks().size() != 0)
                            .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                    break;
            }
            getPopUpsBuilderProjects().printFilteredProjects(filteredProjects);     // Print out filtered list
        }
    }

    // Choose filtering
    private int chooseFilteringForProjects() {
        int chosenFiltering = -1;
        while (chosenFiltering < 0 || chosenFiltering > 3) {
            chosenFiltering = getPopUpsBuilderProjects().chooseFilteringForProjects();     // Print popup with choices
        }
        return chosenFiltering;
    }


}
