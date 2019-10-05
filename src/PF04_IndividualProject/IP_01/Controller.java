package PF04_IndividualProject.IP_01;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private static final String FILE_NAME = "src/PF04_IndividualProject/Resources/IPData.csv";
    private Register register = new Register();
    private MessageBuilder messageBuilder = new MessageBuilder();
    private PrintTasks printTasks = new PrintTasks();
    private JFrame frame = new JFrame("=-_-=");

    public Controller() { }

    public void run() {
        /** Create data and take a look on it */
        uploadData(FILE_NAME);
        register.printStatus();

        int optionChosen = -1;               // Main choice what to do
        while (true) {
            Object[] options = {5, 4, 3, 2, 1};
            while (optionChosen < 0 || optionChosen > 4)
                optionChosen = printTasks.showOptionDialog(frame,
                        messageBuilder.buildMessage(register,"chooseOption"), options);

            switch (optionChosen) {
                case 0:     // Save and quit
                    saveData(FILE_NAME);
                    printTasks.showMessage(frame, messageBuilder.buildMessage(register,"saveData"));
                    System.exit(0);

                case 1:     // Edit task
                    if (register.getTasks().size() != 0) {
                        String chosenTask;
                        do {
                            Object[] choices = register.getTasksIds().toArray();
                            chosenTask = printTasks.showInputDialog(frame,
                                    messageBuilder.buildMessage(register,"chooseTask"), choices);
                        } while (!register.getTasksIds().contains(chosenTask));

                        int chosenActivity = -1;
                        while (chosenActivity < 0 || chosenActivity > 3) {
                            Object[] activities = {4, 3, 2, 1};
                            chosenActivity = printTasks.showOptionDialog(frame,
                                    messageBuilder.buildMessage(register,"chooseActivity", chosenTask, null), activities);
                        }

                        switch (chosenActivity) {
                            case 0:     // Back to main menu
                                break;

                            case 1:     // Remove task
                                register.removeTask(chosenTask);
                                printTasks.showMessage(frame, messageBuilder.buildMessage(register,"removeTask"));
                                break;

                            case 2:     // Mark as done
                                register.markTaskAsDone(chosenTask);
                                printTasks.showMessage(frame, messageBuilder.buildMessage(register,"markTaskAsDone"));
                                break;

                            case 3:     // Edit fields
                                int chosenField = -1;
                                while (chosenField < 0 || chosenField > 4) {
                                    Object[] fields = {5, 4, 3, 2, 1};
                                    chosenField = printTasks.showOptionDialog(frame,
                                            messageBuilder.buildMessage(register, "chooseField", chosenTask, null), fields);

                                    switch (chosenField) {
                                        case 0:     // Back to main menu
                                            break;

                                        case 1:     // Set status
                                            int chosenStatus = -1;
                                            while (chosenStatus < 0 || chosenStatus > 1) {
                                                Object[] statusChoices = {"Done", "Not done"};
                                                chosenStatus = printTasks.showOptionDialog(frame,
                                                        messageBuilder.buildMessage(register,"chooseStatus"), statusChoices);
                                            }
                                            register.setTaskStatus(chosenTask, chosenStatus);
                                            printTasks.showMessage(frame,
                                                    messageBuilder.buildMessage(register,"fixStatus"));
                                            break;

                                        case 2:     // Reassign to project
                                            if (register.getProjects().size() != 0) {
                                                String chosenProject;
                                                do {
                                                    do {
                                                        Object[] projectChoices = register.getProjectsIds().toArray();
                                                        chosenProject = printTasks.showInputDialog(frame,
                                                                messageBuilder.buildMessage(register,"chooseProject"), projectChoices);
                                                    } while (chosenProject == null);
                                                } while (!register.getProjectsIds().contains(chosenProject));

                                                register.removeTaskFromProject(chosenTask);
                                                register.addTaskToProject(chosenTask, chosenProject);
                                                printTasks.showMessage(frame,
                                                        messageBuilder.buildMessage(register,"reassignedTask"));
                                                break;

                                            } else {
                                                printTasks.showMessage(frame,
                                                        messageBuilder.buildMessage(register,"noProjects"));
                                                break;
                                            }

                                        case 3:     // Change due date
                                            String chosenDueDate = "";
                                            DateValidator dateValidator = new DateValidator();
                                            do {
                                                do {
                                                    do {
                                                        chosenDueDate = printTasks.inputLine(frame,
                                                                messageBuilder.buildMessage(register,"chooseDueDate"));    // Ask for due date
                                                    } while (chosenDueDate == null);
                                                } while (chosenDueDate.equals(""));
                                            } while (!dateValidator.isThisDateValid(chosenDueDate, "yyyyMMdd"));

                                            register.findTask(chosenTask).setDueDate(chosenDueDate);
                                            printTasks.showMessage(frame,
                                                    messageBuilder.buildMessage(register,"changedDueDate"));
                                            break;

                                        case 4:
                                            String chosenTitle = "";
                                            do {
                                                do {
                                                    chosenTitle = printTasks.inputLine(frame,
                                                            messageBuilder.buildMessage(register,"chooseTitle"));     // Ask for title
                                                } while (chosenTitle == null);
                                            } while (chosenTitle.equals(""));

                                            register.findTask(chosenTask).setTitle(chosenTitle);
                                            printTasks.showMessage(frame,
                                                    messageBuilder.buildMessage(register,"changedTitle"));
                                            break;
                                    }
                                }
                        }
                    } else {
                        printTasks.showMessage(frame, messageBuilder.buildMessage(register,"noTasks"));
                        break;
                    }
                    break;

                case 2:     // Add new task
                    String newTitle = "";
                    do {
                        do {
                            newTitle = printTasks.inputLine(frame,
                                    messageBuilder.buildMessage(register,"enterTitle"));        // Ask for title
                        } while (newTitle == null);
                    } while (newTitle.equals(""));

                    String newDueDate = "";
                    DateValidator dateValidator = new DateValidator();
                    do {
                        do {
                            do {
                                newDueDate = printTasks.inputLine(frame,
                                        messageBuilder.buildMessage(register,"enterDueDate"));        // Ask for due date
                            } while (newDueDate == null);
                        } while (newDueDate.equals(""));
                    } while (!dateValidator.isThisDateValid(newDueDate, "yyyyMMdd"));

                    register.addTask(new Task(newTitle, newDueDate));
                    printTasks.showMessage(frame, messageBuilder.buildMessage(register,"addedTask"));
                    break;

                case 3:     // Print out sorted
                    if (register.getTasks().size() == 0) {
                        printTasks.showMessage(frame, messageBuilder.buildMessage(register,"noTasks"));

                    } else {
                        int chosenSorting = -1;
                        while (chosenSorting < 0 || chosenSorting > 3) {
                            Object[] sortingChoices = {"project", "due date", "Id", "title"};
                            chosenSorting = printTasks.showOptionDialog(frame,
                                    messageBuilder.buildMessage(register,"chooseSorting"), sortingChoices);
                        }

                        List<Task> sortedList = null;
                        switch (chosenSorting) {
                            case 0:
                                sortedList = register.getTasks().stream()        // Sort by project
                                        .filter(task -> !task.getAssignedToProject().equals(""))
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                        .stream()
                                        .sorted(Comparator.comparing(Task::getAssignedToProject)).collect(Collectors.toList());
                                break;

                            case 1:
                                sortedList = register.getTasks().stream()        // Sort by due date
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                        .stream()
                                        .sorted(Comparator.comparing(Task::getDueDate)).collect(Collectors.toList());
                                break;

                            case 2:
                                sortedList = register.getTasks().stream()        // Sort by Id
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                            case 3:
                                sortedList = register.getTasks().stream()        // Sort by title
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                        .stream()
                                        .sorted(Comparator.comparing(Task::getTitle)).collect(Collectors.toList());
                                break;
                        }
                        printTasks.showMessage(frame,
                                messageBuilder.buildMessage(register,"list", sortedList));
                    }
                    break;

                case 4:     // Print out filtered
                    if (register.getTasks().size() == 0) {
                        printTasks.showMessage(frame,
                                messageBuilder.buildMessage(register,"noTasks"));

                    } else {
                        int chosenFiltering = -1;
                        while (chosenFiltering < 0 || chosenFiltering > 3) {
                            Object[] filteringChoices = {"not done", "done", "not assigned", "assigned"};
                            chosenFiltering = printTasks.showOptionDialog(frame,
                                    messageBuilder.buildMessage(register,"chooseFiltering"), filteringChoices);
                        }

                        List<Task> filteredList = null;
                        switch (chosenFiltering) {
                            case 0:
                                filteredList = register.getTasks().stream()        // Filter not done
                                        .filter(task -> !task.ifDone())
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                            case 1:
                                filteredList = register.getTasks().stream()        // Filter done
                                        .filter(task -> task.ifDone())
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                            case 2:
                                filteredList = register.getTasks().stream()        // Filter not assigned
                                        .filter(task -> task.getAssignedToProject().equals(""))
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                            case 3:
                                String chosenProject = "";        // Choose project
                                if (register.getProjects().size() != 0) {
                                    do {
                                        do {
                                            Object[] projectChoices = register.getProjectsIds().toArray();
                                            chosenProject = printTasks.showInputDialog(frame,
                                                    messageBuilder.buildMessage(register,"chooseProject"), projectChoices);
                                        } while (chosenProject == null);
                                    } while (!register.getProjectsIds().contains(chosenProject));

                                } else {
                                    printTasks.showMessage(frame,
                                            messageBuilder.buildMessage(register,"noProjects"));
                                }

                                String finalChosenProject = chosenProject;
                                filteredList = register.getTasks().stream()        // Filter by project assignment
                                        .filter(task -> task.getAssignedToProject().equals(finalChosenProject))
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                        }
                        printTasks.showMessage(frame, messageBuilder.buildMessage(register,"list", filteredList));
                    }
                    break;
            }
            // Reset to be able to print initial screen
            optionChosen = -1;
        }
    }

    public void uploadData(String fileName) {
        DataFileOperator dataReader = new DataFileOperator();
        register.setTasks(dataReader.getData(fileName).getTasks());
        register.setTasksIds(dataReader.getData(fileName).getTasksIds());
        register.setProjects(dataReader.getData(fileName).getProjects());
        register.setProjectsIds(dataReader.getData(fileName).getProjectsIds());
        register.getTasks().stream().filter(task -> !task.getAssignedToProject().equals(""))
                .forEach(task -> register.addTaskToProject(task.getId(), task.getAssignedToProject()));
    }

    public void saveData(String fileName) {
        DataFileOperator dataWriter = new DataFileOperator();
        dataWriter.appendNewLines(fileName, dataWriter.chooseLinesToKeep('d', fileName), register.getProjects(), register.getTasks());
    }
}
