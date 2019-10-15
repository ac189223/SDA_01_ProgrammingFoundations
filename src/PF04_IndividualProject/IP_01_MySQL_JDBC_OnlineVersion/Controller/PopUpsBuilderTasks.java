package PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Controller;

import PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Model.Register;
import PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Model.Task;
import PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.View.Print;

import javax.swing.*;
import java.util.List;

public class PopUpsBuilderTasks extends PopUpsBuilder {
    private MessageBuilderTasks messageBuilderTasks;
    private Print print;
    private JFrame frame;

    public PopUpsBuilderTasks() {
    this.setMessageBuilderTasks(new MessageBuilderTasks());
    this.setPrint(new Print());
    this.setFrame(new JFrame("=-_-="));
    }

    public MessageBuilderTasks getMessageBuilderTasks() { return messageBuilderTasks; }
    public Print getPrint() { return print; }
    public JFrame getFrame() { return frame; }

    public void setMessageBuilderTasks(MessageBuilderTasks messageBuilderTasks) { this.messageBuilderTasks = messageBuilderTasks; }
    public void setPrint(Print print) { this.print = print; }
    public void setFrame(JFrame frame) { this.frame = frame; }

    /** =================    =================    Tasks popups    =================    ================= */

    // Popup for main menu for tasks
    public int chooseOptionForTask(Register register) {
        Object[] options = {5, 4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderTasks().chooseOptionForTask(register), options);
    }

    // Choice popups
    public String chooseTaskToEdit(Register register) {
        Object[] choices = register.getTasksIds().toArray();
        return getPrint().showInputDialog(getFrame(), getMessageBuilderTasks().chooseTask(), choices);
    }

    public int chooseActivityForTask(Register register, String chosenTask) {
        Object[] activities = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderTasks().chooseActivityForTask(register, chosenTask), activities);
    }

    public int chooseTaskFieldToEdit(Register register, String chosenTask) {
        Object[] fields = {5, 4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderTasks().chooseTaskField(register, chosenTask), fields);
    }

    public int chooseTaskStatus() {
        Object[] statusChoices = {2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderTasks().chooseStatus(), statusChoices);
    }

    public String chooseProjectToAssignTo(Register register) {
        Object[] projectChoices = register.getProjectsIds().toArray();
        return getPrint().showInputDialog(getFrame(), getMessageBuilderTasks().chooseProject(), projectChoices);
    }

    public String chooseProjectForFiltering(Register register) {
        Object[] choices = register.getProjectsIds().toArray();
        return getPrint().showInputDialog(getFrame(), getMessageBuilderTasks().chooseProject(), choices);
    }

    public int chooseSortingForTasks() {
        Object[] sortingChoices = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderTasks().chooseTasksSorting(), sortingChoices);
    }

    public int chooseFilteringForTasks() {
        Object[] filteringChoices = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderTasks().chooseFiltering(), filteringChoices);
    }

    // Input taking popups
    public String changeTaskDueDate() { return getPrint().inputLine(getFrame(), getMessageBuilderTasks().chooseDueDate()); }

    public String chooseNewTitleForTask() { return getPrint().inputLine(getFrame(), getMessageBuilderTasks().chooseTitle()); }

    public String enterNewTitleForTask() { return getPrint().inputLine(getFrame(), getMessageBuilderTasks().enterTaskTitle()); }

    public String enterNewDueDateForTask() { return getPrint().inputLine(getFrame(), getMessageBuilderTasks().enterDueDate()); }

    // Confirmation popups
    public void taskRemovalConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilderTasks().removeTaskConfirmation()); }

    public void taskMarkedAsDoneConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilderTasks().markTaskAsDoneConfirmation()); }

    public void fixTaskStatusConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilderTasks().fixTaskStatusConfirmation()); }

    public void changeTaskDueDateConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilderTasks().changedTaskDueDateConfirmation()); }

    public void changedTaskTitleConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilderTasks().changedTaskTitleConfirmation()); }

    public void addedNewTaskConfirmation(Register register) { getPrint().showMessage(getFrame(), getMessageBuilderTasks().addedTaskConfirmation(register)); }

    //  Popup with list of sorted tasks
    public void printSortedTasks(List<Task> sortedTasks) {
        getPrint().showMessage(getFrame(), getMessageBuilderTasks().listOfTasks(sortedTasks));
    }

    //  Popup with list of filtered tasks
    public void printFilteredTasks(List<Task> filteredTasks) {
        getPrint().showMessage(getFrame(), getMessageBuilderTasks().listOfTasks(filteredTasks));
    }

}
