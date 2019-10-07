package PF04_IndividualProject.IP_01;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    private static final String FILE_NAME = "src/PF04_IndividualProject/Resources/IPData.csv";
    private Register register = new Register();
    private MessageBuilder messageBuilder = new MessageBuilder();
    private Print print = new Print();
    private JFrame frame = new JFrame("=-_-=");

    public Controller() { }

    public void run() {
        /** Create data and take a look on it */
        uploadData(FILE_NAME);
        register.printStatus();

        /** Start with popups */

        int mainChosen = -1;               // Main choice what to do
        while (true) {
            Object[] mains = {4, 3, 2, 1};
            while (mainChosen < 0 || mainChosen > 3)
                mainChosen = print.showOptionDialog(frame,
                        messageBuilder.chooseMain(register), mains);

            switch (mainChosen) {
                case 0:     // Save and quit
                    saveData(FILE_NAME);
                    print.showMessage(frame, messageBuilder.saveData());
                    System.exit(0);

                case 1:               // Project choice what to do
                case 2:               // Task choice what to do
                    int optionChosen = -1;
                    Object[] options = {5, 4, 3, 2, 1};
                    while (optionChosen < 0 || optionChosen > 4)
                        optionChosen = print.showOptionDialog(frame,
                                messageBuilder.chooseOption(register, mainChosen), options);

                    switch (optionChosen) {
                        case 0:     // Back to main menu
                            break;

                        case 1:     // Edit task or project
                            if (register.getProjects().size() == 0 && mainChosen == 1) {
                                print.showMessage(frame, messageBuilder.noProjects());
                                break;

                            } else if (register.getTasks().size() == 0 && mainChosen == 2) {
                                print.showMessage(frame, messageBuilder.noTasks());
                                break;

                            } else {
                                String chosenTask;
                                do {
                                    Object[] choices = null;
                                    if (mainChosen == 1)
                                        choices = register.getProjectsIds().toArray();
                                    else
                                        choices = register.getTasksIds().toArray();
                                    chosenTask = print.showInputDialog(frame,
                                            messageBuilder.chooseTask(mainChosen), choices);
                                } while (!register.getTasksIds().contains(chosenTask) && !register.getProjectsIds().contains(chosenTask));

                                int chosenActivity = -1;
                                while (chosenActivity < 0 || chosenActivity > 3) {
                                    Object[] activities = {4, 3, 2, 1};
                                    chosenActivity = print.showOptionDialog(frame,
                                            messageBuilder.chooseActivity(register, chosenTask, mainChosen), activities);
                                }

                                switch (chosenActivity) {
                                    case 0:     // Back to main menu
                                        break;

                                    case 1:     // Remove task or project
                                        if (mainChosen == 1)
                                            register.removeProjectAlways(chosenTask);          /** REMOVE PROJECT _ AND TASKS ????? */
                                        else
                                            register.removeTask(chosenTask);
                                        print.showMessage(frame, messageBuilder.removeTask(mainChosen));
                                        break;

                                    case 2:     // Mark as done
                                        if (mainChosen == 1)
                                            register.markProjectAsDoneAlways(chosenTask);
                                        else
                                            register.markTaskAsDone(chosenTask);
                                        print.showMessage(frame, messageBuilder.markTaskAsDone(mainChosen));
                                        break;

                                    case 3:     // Edit fields
                                        int chosenField = -1;
                                        while (chosenField < 0 || chosenField > 4) {
                                            Object[] fields = {5, 4, 3, 2, 1};
                                            chosenField = print.showOptionDialog(frame,
                                                    messageBuilder.chooseField(register, chosenTask, mainChosen), fields);

                                            switch (chosenField) {
                                                case 0:     // Back to main menu
                                                    break;

                                                case 1:     // Set status
                                                    int chosenStatus = -1;
                                                    while (chosenStatus < 0 || chosenStatus > 1) {
                                                        Object[] statusChoices = {2, 1};
                                                        chosenStatus = print.showOptionDialog(frame,
                                                                messageBuilder.chooseStatus(), statusChoices);
                                                    }
                                                    if (mainChosen == 1)
                                                        register.setProjectStatus(chosenTask, chosenStatus);
                                                    else
                                                        register.setTaskStatus(chosenTask, chosenStatus);
                                                    print.showMessage(frame,
                                                            messageBuilder.fixStatus(mainChosen));
                                                    break;

                                                case 2:     // Reassign to project or assign tasks
                                                    if (register.getProjects().size() == 0 && mainChosen == 2) {
                                                        print.showMessage(frame,
                                                                messageBuilder.noProjects());
                                                        break;

                                                    } else if (register.getTasks().size() == 0 && mainChosen == 1) {
                                                        print.showMessage(frame,
                                                                messageBuilder.noTasks());
                                                        break;

                                                    } else if (mainChosen == 1) {
                                                        boolean addNextTask = true;
                                                        String chosenTaskToAddToProject;
                                                        do {
                                                            do {
                                                                do {
                                                                    Object[] taskChoices = register.getTasksIds().toArray();
                                                                    chosenTaskToAddToProject = print.showInputDialog(frame,
                                                                            messageBuilder.chooseTask(mainChosen), taskChoices);
                                                                } while (chosenTaskToAddToProject == null);
                                                            } while (!register.getTasksIds().contains(chosenTaskToAddToProject));
                                                            
                                                            if (!register.findTask(chosenTaskToAddToProject).getAssignedToProject().equals(chosenTask)) {
                                                                register.findTask(chosenTaskToAddToProject).setAssignedToProject(chosenTask);
                                                                register.addTaskToProject(chosenTaskToAddToProject, chosenTask);
                                                            }
                                                            print.showMessage(frame,
                                                                    messageBuilder.addedTaskToProject(chosenTaskToAddToProject, chosenTask));

                                                            int ifAddNext = -1;
                                                            while (ifAddNext < 0 || ifAddNext > 1) {
                                                                Object[] statusChoices = {2, 1};
                                                                ifAddNext = print.showOptionDialog(frame,
                                                                        messageBuilder.ifAddNext(), statusChoices);
                                                            }
                                                            if (ifAddNext == 0)
                                                                addNextTask = false;

                                                        } while (addNextTask);
                                                        break;

                                                    } else {
                                                        String chosenProject;
                                                        do {
                                                            do {
                                                                Object[] projectChoices = register.getProjectsIds().toArray();
                                                                chosenProject = print.showInputDialog(frame,
                                                                        messageBuilder.chooseProject(), projectChoices);
                                                            } while (chosenProject == null);
                                                        } while (!register.getProjectsIds().contains(chosenProject));

                                                        if (!register.findTask(chosenTask).getAssignedToProject().equals(chosenProject)) {
                                                            register.removeTaskFromProject(chosenTask);
                                                            register.addTaskToProject(chosenTask, chosenProject);
                                                        }
                                                        print.showMessage(frame,
                                                                messageBuilder.reassignedTask());
                                                        break;

                                                    }

                                                case 3:     // Change due date
                                                    String chosenDueDate = "";
                                                    DateValidator dateValidator = new DateValidator();
                                                    do {
                                                        do {
                                                            do {
                                                                chosenDueDate = print.inputLine(frame,
                                                                        messageBuilder.chooseDueDate());    // Ask for due date
                                                            } while (chosenDueDate == null);
                                                        } while (chosenDueDate.equals(""));
                                                    } while (!dateValidator.isThisDateValid(chosenDueDate, "yyyyMMdd"));

                                                    if (mainChosen == 1)
                                                        register.findProject(chosenTask).setDueDate(chosenDueDate);
                                                    else
                                                        register.findTask(chosenTask).setDueDate(chosenDueDate);
                                                    print.showMessage(frame,
                                                            messageBuilder.changedDueDate(mainChosen));
                                                    break;

                                                case 4:
                                                    String chosenTitle = "";
                                                    do {
                                                        do {
                                                            chosenTitle = print.inputLine(frame,
                                                                    messageBuilder.chooseTitle());     // Ask for title
                                                        } while (chosenTitle == null);
                                                    } while (chosenTitle.equals(""));

                                                    if (mainChosen == 1)
                                                        register.findProject(chosenTask).setTitle(chosenTitle);
                                                    else
                                                        register.findTask(chosenTask).setTitle(chosenTitle);
                                                    print.showMessage(frame,
                                                            messageBuilder.changedTitle(mainChosen));
                                                    break;
                                            }
                                        }
                                }
                            }
                            break;

                        case 2:     // Add new task
                            String newTitle = "";
                            do {
                                do {
                                    newTitle = print.inputLine(frame,
                                            messageBuilder.enterTitle(mainChosen));        // Ask for title
                                } while (newTitle == null);
                            } while (newTitle.equals(""));

                            String newDueDate = "";
                            DateValidator dateValidator = new DateValidator();
                            do {
                                do {
                                    do {
                                        newDueDate = print.inputLine(frame,
                                                messageBuilder.enterDueDate());        // Ask for due date
                                    } while (newDueDate == null);
                                } while (newDueDate.equals(""));
                            } while (!dateValidator.isThisDateValid(newDueDate, "yyyyMMdd"));

                            if (mainChosen == 1)
                                register.addProject(new Project(newTitle, newDueDate));
                            else
                                register.addTask(new Task(newTitle, newDueDate));
                            print.showMessage(frame, messageBuilder.addedTask(register, mainChosen));
                            break;

                        case 3:     // Print out sorted
                            if (register.getProjects().size() == 0 && mainChosen == 1) {
                                print.showMessage(frame, messageBuilder.noProjects());
                                break;

                            } else if (register.getTasks().size() == 0 && mainChosen == 2) {
                                print.showMessage(frame, messageBuilder.noTasks());
                                break;

                            } else {
                                int chosenSorting = -1;
                                while (chosenSorting < 0 || chosenSorting > 3) {
                                    Object[] sortingChoices = {4, 3, 2, 1};
                                    chosenSorting = print.showOptionDialog(frame,
                                            messageBuilder.chooseSorting(mainChosen), sortingChoices);
                                }

                                List<Task> sortedTasks = null;
                                List<Project> sortedProjects = null;
                                switch (chosenSorting) {
                                    case 0:
                                        if (mainChosen == 1) {
                                            sortedProjects = register.getProjects();       // Sort by number of tasks
                                            for (int i = 0; i < sortedProjects.size(); i++) {                  // Use bubble sort
                                                for (int j = 0; j < sortedProjects.size() - i - 1; j++) {
                                                    if((sortedProjects.get(j)).getAssignedTasks().size() >
                                                            (sortedProjects.get(j + 1)).getAssignedTasks().size()) {
                                                        Collections.swap(sortedProjects, j, j + 1);
                                                    }
                                                }
                                            }
                                        }
                                        else
                                            sortedTasks = register.getTasks().stream()        // Sort by project
                                                .filter(task -> !task.getAssignedToProject().equals(""))
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                                .stream()
                                                .sorted(Comparator.comparing(Task::getAssignedToProject)).collect(Collectors.toList());
                                        break;

                                    case 1:
                                        if (mainChosen == 1)
                                            sortedProjects = register.getProjects().stream()        // Sort by due date
                                                    .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList())
                                                    .stream()
                                                    .sorted(Comparator.comparing(Project::getDueDate)).collect(Collectors.toList());
                                        else
                                            sortedTasks = register.getTasks().stream()        // Sort by due date
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                                .stream()
                                                .sorted(Comparator.comparing(Task::getDueDate)).collect(Collectors.toList());
                                        break;

                                    case 2:
                                        if (mainChosen == 1)
                                            sortedProjects = register.getProjects().stream()        // Sort by Id
                                                    .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                                        else
                                            sortedTasks = register.getTasks().stream()        // Sort by Id
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                        break;

                                    case 3:
                                        if (mainChosen == 1)
                                            sortedProjects = register.getProjects().stream()        // Sort by title
                                                    .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList())
                                                    .stream()
                                                    .sorted(Comparator.comparing(Project::getTitle)).collect(Collectors.toList());
                                        else
                                            sortedTasks = register.getTasks().stream()        // Sort by title
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                                .stream()
                                                .sorted(Comparator.comparing(Task::getTitle)).collect(Collectors.toList());
                                        break;
                                }
                                if (mainChosen == 1)
                                    print.showMessage(frame, messageBuilder.list(sortedProjects, null, mainChosen));
                                else
                                    print.showMessage(frame, messageBuilder.list(null, sortedTasks, mainChosen));
                            }
                            break;

                        case 4:     // Print out filtered
                            if (register.getProjects().size() == 0 && mainChosen == 1) {
                                print.showMessage(frame, messageBuilder.noProjects());
                                break;

                            } else if (register.getTasks().size() == 0 && mainChosen == 2) {
                                print.showMessage(frame, messageBuilder.noTasks());
                                break;

                            } else {
                                int chosenFiltering = -1;
                                while (chosenFiltering < 0 || chosenFiltering > 3) {
                                    Object[] filteringChoices = {4, 3, 2, 1};
                                    chosenFiltering = print.showOptionDialog(frame,
                                            messageBuilder.chooseFiltering(), filteringChoices);
                                }

                                List<Task> filteredTasks = null;
                                List<Project> filteredProjects = null;
                                switch (chosenFiltering) {
                                    case 0:
                                        if (mainChosen == 1)
                                            filteredProjects = register.getProjects().stream()        // Filter unfinished
                                                    .filter(task -> !task.ifDone())
                                                    .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                                        else
                                            filteredTasks = register.getTasks().stream()        // Filter unfinished
                                                    .filter(task -> !task.ifDone())
                                                    .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                        break;

                                    case 1:
                                        if (mainChosen == 1)
                                            filteredProjects = register.getProjects().stream()        // Filter finished
                                                    .filter(Project::ifDone)
                                                    .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                                        else
                                            filteredTasks = register.getTasks().stream()        // Filter finished
                                                .filter(Task::ifDone)
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                        break;

                                    case 2:
                                        if (mainChosen == 1)
                                            filteredProjects = register.getProjects().stream()        // Filter without assigned tasks
                                                    .filter(project -> project.getAssignedTasks().size() == 0)
                                                    .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                                        else
                                            filteredTasks = register.getTasks().stream()        // Filter not assigned
                                                .filter(task -> task.getAssignedToProject().equals(""))
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                        break;

                                    case 3:
                                        if (mainChosen == 1)
                                            filteredProjects = register.getProjects().stream()        // Filter with assigned tasks
                                                    .filter(project -> project.getAssignedTasks().size() != 0)
                                                    .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
                                        else {
                                            String chosenProject = "";        // Choose project
                                            if (register.getProjects().size() != 0) {
                                                do {
                                                    do {
                                                        Object[] projectChoices = register.getProjectsIds().toArray();
                                                        chosenProject = print.showInputDialog(frame,
                                                                messageBuilder.chooseProject(), projectChoices);
                                                    } while (chosenProject == null);
                                                } while (!register.getProjectsIds().contains(chosenProject));

                                            } else {
                                                print.showMessage(frame,
                                                        messageBuilder.noProjects());
                                            }

                                            String finalChosenProject = chosenProject;
                                            filteredTasks = register.getTasks().stream()        // Filter by project assignment
                                                    .filter(task -> task.getAssignedToProject().equals(finalChosenProject))
                                                    .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                        }
                                        break;
                                }
                                if (mainChosen == 1)
                                    print.showMessage(frame, messageBuilder.list(filteredProjects, null, mainChosen));
                                else
                                    print.showMessage(frame, messageBuilder.list(null, filteredTasks, mainChosen));
                            }
                            break;
                    }
                    break;

                case 3:                 // Print all
                    if (register.getTasks().size() == 0 && register.getProjects().size() == 0) {
                        print.showMessage(frame, messageBuilder.noTasksNoProjects());

                    } else {
                        print.showMessage(frame,
                                messageBuilder.listForMain(register));
                    }
                    break;
            }
            // Reset to be able to print initial screen
            mainChosen = -1;
        }
    }

    private void uploadData(String fileName) {
        DataFileOperator dataReader = new DataFileOperator();
        register.setTasks(dataReader.getData(fileName).getTasks());
        register.setTasksIds(dataReader.getData(fileName).getTasksIds());
        register.setProjects(dataReader.getData(fileName).getProjects());
        register.setProjectsIds(dataReader.getData(fileName).getProjectsIds());
        register.getTasks().stream().filter(task -> !task.getAssignedToProject().equals(""))
                .forEach(task -> register.addTaskToProject(task.getId(), task.getAssignedToProject()));
    }

    private void saveData(String fileName) {
        DataFileOperator dataWriter = new DataFileOperator();
        dataWriter.appendNewLines(fileName, dataWriter.chooseLinesToKeep('d', fileName), register.getProjects(), register.getTasks());
    }
}
