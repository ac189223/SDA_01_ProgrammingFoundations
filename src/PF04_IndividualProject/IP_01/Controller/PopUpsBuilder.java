package PF04_IndividualProject.IP_01.Controller;

import PF04_IndividualProject.IP_01.Model.Project;
import PF04_IndividualProject.IP_01.Model.Register;
import PF04_IndividualProject.IP_01.View.Print;

import javax.swing.*;
import java.util.List;

public class PopUpsBuilder {
    private MessageBuilder messageBuilder;
    private Print print;
    private JFrame frame;

    public PopUpsBuilder() {
    this.setMessageBuilder(new MessageBuilder());
    this.setPrint(new Print());
    this.setFrame(new JFrame("=-_-="));
    }

    public MessageBuilder getMessageBuilder() { return messageBuilder; }
    public Print getPrint() { return print; }
    public JFrame getFrame() { return frame; }

    public void setMessageBuilder(MessageBuilder messageBuilder) { this.messageBuilder = messageBuilder; }
    public void setPrint(Print print) { this.print = print; }
    public void setFrame(JFrame frame) { this.frame = frame; }

    /** =================    =================    Main popups    =================   ================= */

    public int mainChoice(Register register) {
        Object[] mains = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilder().chooseMain(register), mains);
    }

    public void saveConfirmation() {
        getPrint().showMessage(getFrame(), getMessageBuilder().saveData());
    }

    public void noProjectsInfo() { getPrint().showMessage(getFrame(), getMessageBuilder().noProjects()); }

    public void noTasksInfo() {
        getPrint().showMessage(getFrame(), getMessageBuilder().noProjects());
    }

    public void noTasksNoProjectsInfo() {
        getPrint().showMessage(getFrame(), getMessageBuilder().noTasksNoProjects());
    }

    public void mainTasksAndProjectsList(Register register) { getPrint().showMessage(getFrame(), getMessageBuilder().listForMain(register));
    }

    /** =================    =================    Projects popups    =================    ================= */

    public int chooseOptionForProject(Register register) {
        Object[] options = {5, 4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilder().chooseOption(register, 1), options);
    }

    public String chooseProjectToEdit(Register register) {
        Object[] choices = register.getProjectsIds().toArray();
        return getPrint().showInputDialog(getFrame(), getMessageBuilder().chooseTask(), choices);
    }

    public int chooseActivityForProject(Register register, String chosenProject) {
        Object[] activities = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilder().chooseActivityForProject(register, chosenProject), activities);
    }

    public void projectRemovalConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilder().removeProject()); }

    public void projectMarkedAsDoneConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilder().markProjectAsDone()); }

    public int chooseProjectFieldToEdit(Register register, String chosenProject) {
        Object[] fields = {5, 4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilder().chooseProjectField(register, chosenProject), fields);
    }

    public int chooseProjectStatus() {
        Object[] statusChoices = {2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilder().chooseStatus(), statusChoices);
    }

    public void fixProjectStatusConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilder().fixProjectStatus()); }

    public String chooseTaskToAddToTheProject(Register register) {
        Object[] taskChoices = register.getTasksIds().toArray();
        return getPrint().showInputDialog(getFrame(), getMessageBuilder().chooseTask(), taskChoices);
    }

    public void addedTaskToProjectConfirmation(String chosenTaskToAddToProject, String chosenProject) {
        getPrint().showMessage(getFrame(), getMessageBuilder().addedTaskToProject(chosenTaskToAddToProject, chosenProject));
    }

    public void taskAlreadyInProjectInformation(String chosenTaskToAddToProject, String chosenProject) {
        getPrint().showMessage(getFrame(), getMessageBuilder().taskAlreadyInProject(chosenTaskToAddToProject, chosenProject));
    }

    public int ifAddNext() {
        Object[] statusChoices = {2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilder().ifAddNext(), statusChoices);
    }

    public String changeProjectDueDate() { return getPrint().inputLine(getFrame(), getMessageBuilder().chooseDueDate()); }

    public void changeDueDateConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilder().changedProjectDueDate()); }

    public void changedProjectTitleConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilder().changedProjectTitle()); }

    public String chooseNewTitleForProject() { return getPrint().inputLine(getFrame(), getMessageBuilder().chooseTitle()); }

    public String enterNewTitleForProject() { return getPrint().inputLine(getFrame(), getMessageBuilder().enterProjectTitle()); }

    public String enterNewDueDateForProject() { return getPrint().inputLine(getFrame(), getMessageBuilder().enterDueDate()); }

    public void addedNewTaskConfirmation(Register register) { getPrint().showMessage(getFrame(), getMessageBuilder().addedTask(register)); }

    public int chooseSortingForProjects() {
        Object[] sortingChoices = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilder().chooseProjectsSorting(), sortingChoices);
    }

    public void printSortedProjects(List<Project> sortedProjects) {
        getPrint().showMessage(getFrame(), getMessageBuilder().listOfProjects(sortedProjects));
    }

    public int chooseFilteringForProjects() {
        Object[] filteringChoices = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilder().chooseFiltering(), filteringChoices);
    }

    public void printFilteredProjects(List<Project> filteredProjects) {
        getPrint().showMessage(getFrame(), getMessageBuilder().listOfProjects(filteredProjects));
    }
}
