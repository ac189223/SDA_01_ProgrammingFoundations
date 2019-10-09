package PF04_IndividualProject.IP_01.Controller;

import PF04_IndividualProject.IP_01.Model.Project;
import PF04_IndividualProject.IP_01.Model.Register;
import PF04_IndividualProject.IP_01.Model.Task;
import PF04_IndividualProject.IP_01.View.Print;

import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerTasks {
    private static final String FILE_NAME = "src/PF04_IndividualProject/Resources/IPData.csv";
    private Register register = new Register();
    private MessageBuilderTasks messageBuilderTasks = new MessageBuilderTasks();
    private Print print = new Print();
    private JFrame frame = new JFrame("=-_-=");

    public ControllerTasks() { }

    public void run(Register register) {
        /** Create data and take a look on it */
        uploadData(FILE_NAME);
        this.register.printStatus();

        /** Start with popups */

        int mainChosen = -1;               // Main choice what to do
        while (true) {
            Object[] mains = {4, 3, 2, 1};
            while (mainChosen < 0 || mainChosen > 3)
                mainChosen = print.showOptionDialog(frame,
                        messageBuilderTasks.chooseMain(this.register), mains);

            switch (mainChosen) {
                case 0:     // Save and quit
                    saveData(FILE_NAME);
                    print.showMessage(frame, messageBuilderTasks.saveData());
                    System.exit(0);

                case 1:               // Project choice what to do
                case 2:               // Task choice what to do
                    int optionChosen = -1;
                    Object[] options = {5, 4, 3, 2, 1};
                    while (optionChosen < 0 || optionChosen > 4)
                        optionChosen = print.showOptionDialog(frame,
                                messageBuilderTasks.chooseOptionForTask(this.register), options);

                    switch (optionChosen) {
                        case 0:     // Back to main menu
                            break;

                        case 1:     // Edit task or project
                            if (this.register.getTasks().size() == 0) {
                                print.showMessage(frame, messageBuilderTasks.noTasks());
                                break;

                            } else {
                                String chosenTask;
                                do {
                                    Object[] choices = null;
                                    choices = this.register.getTasksIds().toArray();
                                    chosenTask = print.showInputDialog(frame,
                                            messageBuilderTasks.chooseTask(), choices);
                                } while (!this.register.getTasksIds().contains(chosenTask) && !this.register.getProjectsIds().contains(chosenTask));

                                int chosenActivity = -1;
                                while (chosenActivity < 0 || chosenActivity > 3) {
                                    Object[] activities = {4, 3, 2, 1};
                                    chosenActivity = print.showOptionDialog(frame,
                                            messageBuilderTasks.chooseActivityForTask(this.register, chosenTask), activities);
                                }

                                switch (chosenActivity) {
                                    case 0:     // Back to main menu
                                        break;

                                    case 1:     // Remove task or project
                                        this.register.removeTask(chosenTask);
                                        print.showMessage(frame, messageBuilderTasks.removeTask());
                                        break;

                                    case 2:     // Mark as done
                                        this.register.markTaskAsDone(chosenTask);
                                        print.showMessage(frame, messageBuilderTasks.markTaskAsDone());
                                        break;

                                    case 3:     // Edit fields
                                        int chosenField = -1;
                                        while (chosenField < 0 || chosenField > 4) {
                                            Object[] fields = {5, 4, 3, 2, 1};
                                            chosenField = print.showOptionDialog(frame,
                                                    messageBuilderTasks.chooseTaskField(this.register, chosenTask), fields);

                                            switch (chosenField) {
                                                case 0:     // Back to main menu
                                                    break;

                                                case 1:     // Set status
                                                    int chosenStatus = -1;
                                                    while (chosenStatus < 0 || chosenStatus > 1) {
                                                        Object[] statusChoices = {2, 1};
                                                        chosenStatus = print.showOptionDialog(frame,
                                                                messageBuilderTasks.chooseStatus(), statusChoices);
                                                    }
                                                    this.register.setTaskStatus(chosenTask, chosenStatus);
                                                    print.showMessage(frame,
                                                            messageBuilderTasks.fixTaskStatus());
                                                    break;

                                                case 2:     // Reassign to project or assign tasks
                                                    if (this.register.getProjects().size() == 0) {
                                                        print.showMessage(frame,
                                                                messageBuilderTasks.noProjects());
                                                        break;

                                                    } else {
                                                        String chosenProject;
                                                        do {
                                                            do {
                                                                Object[] projectChoices = this.register.getProjectsIds().toArray();
                                                                chosenProject = print.showInputDialog(frame,
                                                                        messageBuilderTasks.chooseProject(), projectChoices);
                                                            } while (chosenProject == null);
                                                        } while (!this.register.getProjectsIds().contains(chosenProject));

                                                        if (!this.register.findTask(chosenTask).getAssignedToProject().equals(chosenProject)) {
                                                            this.register.removeTaskFromProject(chosenTask);
                                                            this.register.addTaskToProject(chosenTask, chosenProject);
                                                        }
                                                        print.showMessage(frame,
                                                                messageBuilderTasks.reassignedTask());
                                                        break;

                                                    }

                                                case 3:     // Change due date
                                                    String chosenDueDate = "";
                                                    DateValidator dateValidator = new DateValidator();
                                                    do {
                                                        do {
                                                            do {
                                                                chosenDueDate = print.inputLine(frame,
                                                                        messageBuilderTasks.chooseDueDate());    // Ask for due date
                                                            } while (chosenDueDate == null);
                                                        } while (chosenDueDate.equals(""));
                                                    } while (!dateValidator.isThisDateValid(chosenDueDate, "yyyyMMdd"));

                                                    this.register.findTask(chosenTask).setDueDate(chosenDueDate);
                                                    print.showMessage(frame,
                                                            messageBuilderTasks.changedTaskDueDate());
                                                    break;

                                                case 4:
                                                    String chosenTitle = "";
                                                    do {
                                                        do {
                                                            chosenTitle = print.inputLine(frame,
                                                                    messageBuilderTasks.chooseTitle());     // Ask for title
                                                        } while (chosenTitle == null);
                                                    } while (chosenTitle.equals(""));

                                                    this.register.findTask(chosenTask).setTitle(chosenTitle);
                                                    print.showMessage(frame,
                                                            messageBuilderTasks.changedTaskTitle());
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
                                            messageBuilderTasks.enterTaskTitle());        // Ask for title
                                } while (newTitle == null);
                            } while (newTitle.equals(""));

                            String newDueDate = "";
                            DateValidator dateValidator = new DateValidator();
                            do {
                                do {
                                    do {
                                        newDueDate = print.inputLine(frame,
                                                messageBuilderTasks.enterDueDate());        // Ask for due date
                                    } while (newDueDate == null);
                                } while (newDueDate.equals(""));
                            } while (!dateValidator.isThisDateValid(newDueDate, "yyyyMMdd"));

                            this.register.addTask(new Task(newTitle, newDueDate));
                            print.showMessage(frame, messageBuilderTasks.addedTask(this.register));
                            break;

                        case 3:     // Print out sorted
                            if (this.register.getTasks().size() == 0) {
                                print.showMessage(frame, messageBuilderTasks.noTasks());
                                break;

                            } else {
                                int chosenSorting = -1;
                                while (chosenSorting < 0 || chosenSorting > 3) {
                                    Object[] sortingChoices = {4, 3, 2, 1};
                                    chosenSorting = print.showOptionDialog(frame,
                                            messageBuilderTasks.chooseTasksSorting(), sortingChoices);
                                }

                                List<Task> sortedTasks = null;
                                List<Project> sortedProjects = null;
                                switch (chosenSorting) {
                                    case 0:
                                            sortedTasks = this.register.getTasks().stream()        // Sort by project
                                                .filter(task -> !task.getAssignedToProject().equals(""))
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                                .stream()
                                                .sorted(Comparator.comparing(Task::getAssignedToProject)).collect(Collectors.toList());
                                        break;

                                    case 1:
                                            sortedTasks = this.register.getTasks().stream()        // Sort by due date
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                                .stream()
                                                .sorted(Comparator.comparing(Task::getDueDate)).collect(Collectors.toList());
                                        break;

                                    case 2:
                                            sortedTasks = this.register.getTasks().stream()        // Sort by Id
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                        break;

                                    case 3:
                                            sortedTasks = this.register.getTasks().stream()        // Sort by title
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                                .stream()
                                                .sorted(Comparator.comparing(Task::getTitle)).collect(Collectors.toList());
                                        break;
                                }
                                print.showMessage(frame, messageBuilderTasks.listOfTasks(sortedTasks));
                            }
                            break;

                        case 4:     // Print out filtered
                            if (this.register.getTasks().size() == 0) {
                                print.showMessage(frame, messageBuilderTasks.noTasks());
                                break;

                            } else {
                                int chosenFiltering = -1;
                                while (chosenFiltering < 0 || chosenFiltering > 3) {
                                    Object[] filteringChoices = {4, 3, 2, 1};
                                    chosenFiltering = print.showOptionDialog(frame,
                                            messageBuilderTasks.chooseFiltering(), filteringChoices);
                                }

                                List<Task> filteredTasks = null;
                                List<Project> filteredProjects = null;
                                switch (chosenFiltering) {
                                    case 0:
                                            filteredTasks = this.register.getTasks().stream()        // Filter unfinished
                                                    .filter(task -> !task.ifDone())
                                                    .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                        break;

                                    case 1:
                                            filteredTasks = this.register.getTasks().stream()        // Filter finished
                                                .filter(Task::ifDone)
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                        break;

                                    case 2:
                                            filteredTasks = this.register.getTasks().stream()        // Filter not assigned
                                                .filter(task -> task.getAssignedToProject().equals(""))
                                                .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                        break;

                                    case 3:
                                            String chosenProject = "";        // Choose project
                                            if (this.register.getProjects().size() != 0) {
                                                do {
                                                    do {
                                                        Object[] projectChoices = this.register.getProjectsIds().toArray();
                                                        chosenProject = print.showInputDialog(frame,
                                                                messageBuilderTasks.chooseProject(), projectChoices);
                                                    } while (chosenProject == null);
                                                } while (!this.register.getProjectsIds().contains(chosenProject));

                                            } else {
                                                print.showMessage(frame,
                                                        messageBuilderTasks.noProjects());
                                            }

                                            String finalChosenProject = chosenProject;
                                            filteredTasks = this.register.getTasks().stream()        // Filter by project assignment
                                                    .filter(task -> task.getAssignedToProject().equals(finalChosenProject))
                                                    .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                        break;
                                }
                                print.showMessage(frame, messageBuilderTasks.listOfTasks(filteredTasks));
                            }
                            break;
                    }
                    break;

                case 3:                 // Print all
                    if (this.register.getTasks().size() == 0 && this.register.getProjects().size() == 0) {
                        print.showMessage(frame, messageBuilderTasks.noTasksNoProjects());

                    } else {
                        print.showMessage(frame,
                                messageBuilderTasks.listForMain(this.register));
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
