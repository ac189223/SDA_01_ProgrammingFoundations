package PF04_IndividualProject.IP_01_MySQLVersion_JDBC.Controller;

import PF04_IndividualProject.IP_04_SplitControllerVersion.Model.Register;

public class Controller {
    private static final String FILE_NAME = "src/PF04_IndividualProject/Resources/IPData.csv";
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
        uploadData(FILE_NAME);
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

    private void uploadData(String fileName) {
        DataFileOperator dataReader = new DataFileOperator();
        getRegister().setTasks(dataReader.getData(fileName).getTasks());
        getRegister().setTasksIds(dataReader.getData(fileName).getTasksIds());
        getRegister().setProjects(dataReader.getData(fileName).getProjects());
        getRegister().setProjectsIds(dataReader.getData(fileName).getProjectsIds());
        getRegister().getTasks().stream().filter(task -> !task.getAssignedToProject().equals(""))
                .forEach(task -> getRegister().addTaskToProject(task.getId(), task.getAssignedToProject()));
    }

    private void saveDataChosen() {
        saveData(FILE_NAME);
        getPopUpsBuilder().saveConfirmation();
        System.exit(0);
    }

    private void saveData(String fileName) {
        DataFileOperator dataWriter = new DataFileOperator();
        dataWriter.appendNewLines(fileName,
                dataWriter.chooseLinesToKeep('d', fileName), getRegister().getProjects(), getRegister().getTasks());
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
