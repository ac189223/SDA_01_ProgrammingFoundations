package PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Controller;

import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Register;

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

    public void run() {
        /** Create data and take a look on it */
        uploadData();
        getRegister().printStatus();

        /** Start with popups */
        while (true) { mainChoice(); }
    }

    private void mainChoice() {
        int mainChosen = -1;                // Main choice what to do
        while (mainChosen < 0 || mainChosen > 3)
            mainChosen = getPopUpsBuilder().mainChoice(getRegister());

        switch (mainChosen) {
            case 0:                         // Save and quit
                saveDataChosen();
            case 1:                         // Project choice what to do
                projectsChosen();
                break;
            case 2:                         // Task choice what to do
                tasksChosen();
                break;
            case 3:                         // Print all
                printAllChosen();
                break;
        }
    }

    private void uploadData() {
        MySQLConnector dataReader = new MySQLConnector();
        DataLists dataLists = dataReader.readData();
        getRegister().setTasks(dataLists.getTasks());
        getRegister().getTasks().forEach(task -> getRegister().getTasksIds().add(task.getId()));
        getRegister().setProjects(dataLists.getProjects());
        getRegister().getProjects().forEach(project -> getRegister().getProjectsIds().add(project.getId()));
        getRegister().getTasks().stream().filter(task -> !task.getAssignedToProject().equals(""))
                .forEach(task -> getRegister().addTaskToProject(task.getId(), task.getAssignedToProject()));
    }

    private void saveDataChosen() {
        saveData();
        getPopUpsBuilder().saveConfirmation();
        System.exit(0);
    }

    private void saveData() {
        MySQLConnector dataWriter = new MySQLConnector();
        dataWriter.dropDatabase();
        dataWriter.createDatabase();
        dataWriter.populateTables(register);
    }

    private void projectsChosen() {
        getControllerProjects().run(getRegister());
    }

    private void tasksChosen() {
        getControllerTasks().run(getRegister());
    }

    private void printAllChosen() {
        if (getRegister().getTasks().size() == 0 && getRegister().getProjects().size() == 0) {
            getPopUpsBuilder().noTasksNoProjectsInfo();

        } else {
            getPopUpsBuilder().mainTasksAndProjectsList(getRegister());
        }
    }
}
