package PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Controller;

import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Interface.DataLists;
import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Interface.MySQLConnector;
import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Register;

public class Controller {
    private ControllerProjects controllerProjects;
    private ControllerTasks controllerTasks;
    private PopUpsBuilder popUpsBuilder;
    private Register register;

    public Controller() {
        this.setControllerProjects(new ControllerProjects());
        this.setControllerTasks(new ControllerTasks());
        this.setPopUpsBuilder(new PopUpsBuilder());
        this.setRegister(new Register());
    }

    public ControllerProjects getControllerProjects() { return controllerProjects; }
    public ControllerTasks getControllerTasks() { return controllerTasks; }
    public PopUpsBuilder getPopUpsBuilder() { return popUpsBuilder; }
    public Register getRegister() { return register; }

    public void setControllerProjects(ControllerProjects controllerProjects) { this.controllerProjects = controllerProjects; }
    public void setControllerTasks(ControllerTasks controllerTasks) { this.controllerTasks = controllerTasks; }
    public void setPopUpsBuilder(PopUpsBuilder popUpsBuilder) { this.popUpsBuilder = popUpsBuilder; }
    public void setRegister(Register register) { this.register = register; }

    /** =================    =================    Controller    =================   ================= */

    // Main program
    public void run() {
        uploadData();                                   // Upload data from MySQL database
        getRegister().printStatus();                    // Check if successful

        while (true) { mainChoice(); }                  // Start with popups and get back to main menu every time
    }

    // Main menu, first choice
    private void mainChoice() {
        int mainChosen = -1;
        while (mainChosen < 0 || mainChosen > 3)
            mainChosen = getPopUpsBuilder().mainChoice(getRegister());

        switch (mainChosen) {
            case 0:                         // Save and quit
                saveDataChosen();
            case 1:                         // Work with projects
                projectsChosen();
                break;
            case 2:                         // Work with tasks
                tasksChosen();
                break;
            case 3:                         // Print out all
                printAllChosen();
                break;
        }
    }

    // Upload data from MySQL database
    private void uploadData() {
        MySQLConnector dataReader = new MySQLConnector();
        DataLists dataLists = dataReader.readData();                    // Retrieve data in DataLists format
                                                                        // And populate registers lists
        getRegister().setTasks(dataLists.getTasks());
        getRegister().getTasks().forEach(task -> getRegister().getTasksIds().add(task.getId()));
        getRegister().setProjects(dataLists.getProjects());
        getRegister().getProjects().forEach(project -> getRegister().getProjectsIds().add(project.getId()));
                                                                        // Create tasks assignations in projects
        getRegister().getTasks().stream().filter(task -> !task.getAssignedToProject().equals(""))
                .forEach(task -> getRegister().addTaskToProject(task.getId(), task.getAssignedToProject()));
    }

    // Save data
    private void saveDataChosen() {
        saveData();                                                     // Save data into MySQL database
        getPopUpsBuilder().saveConfirmation();                          // Print confirmation
        System.exit(0);                                          // Close application
    }

    // Save data into MySQL database
    private void saveData() {
        MySQLConnector dataWriter = new MySQLConnector();
        dataWriter.dropTables();                                      // Delete old tables
        dataWriter.createTables();                                    // Create new tables
        dataWriter.populateTables(register);                            // Write data into new tables
    }

    // Work with projects
    private void projectsChosen() {
        getControllerProjects().run(getRegister());
    }           // Run projects register

    // Work with tasks
    private void tasksChosen() {
        getControllerTasks().run(getRegister());
    }                 // Run tasks register

    // Print out all tasks and projects
    private void printAllChosen() {
        if (getRegister().getTasks().size() == 0 && getRegister().getProjects().size() == 0) {
            getPopUpsBuilder().noTasksNoProjectsInfo();                     // Inform if database is empty

        } else {
            getPopUpsBuilder().mainTasksAndProjectsList(getRegister());     // Print out all tasks and projects
        }
    }
}
