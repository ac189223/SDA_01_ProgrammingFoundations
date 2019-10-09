package PF04_IndividualProject.IP_01.Controller;

import PF04_IndividualProject.IP_01.Model.Project;
import PF04_IndividualProject.IP_01.Model.Register;
import PF04_IndividualProject.IP_01.View.Print;

import javax.swing.*;
import java.util.List;

public class PopUpsBuilderProjects extends PopUpsBuilder{
    private MessageBuilderProjects messageBuilderProjects;
    private Print print;
    private JFrame frame;

    public PopUpsBuilderProjects() {
    this.setMessageBuilderProjects(new MessageBuilderProjects());
    this.setPrint(new Print());
    this.setFrame(new JFrame("=-_-="));
    }

    public MessageBuilderProjects getMessageBuilderProjects() { return messageBuilderProjects; }
    public Print getPrint() { return print; }
    public JFrame getFrame() { return frame; }

    public void setMessageBuilderProjects(MessageBuilderProjects messageBuilderProjects) { this.messageBuilderProjects = messageBuilderProjects; }
    public void setPrint(Print print) { this.print = print; }
    public void setFrame(JFrame frame) { this.frame = frame; }

    /** =================    =================    Projects popups    =================    ================= */

    public int chooseOptionForProject(Register register) {
        Object[] options = {5, 4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderProjects().chooseOptionForProject(register), options);
    }

    public String chooseProjectToEdit(Register register) {
        Object[] choices = register.getProjectsIds().toArray();
        return getPrint().showInputDialog(getFrame(), getMessageBuilderProjects().chooseTask(), choices);
    }

    public int chooseActivityForProject(Register register, String chosenProject) {
        Object[] activities = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderProjects().chooseActivityForProject(register, chosenProject), activities);
    }

    public void projectRemovalConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilderProjects().removeProject()); }

    public void projectMarkedAsDoneConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilderProjects().markProjectAsDone()); }

    public int chooseProjectFieldToEdit(Register register, String chosenProject) {
        Object[] fields = {5, 4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderProjects().chooseProjectField(register, chosenProject), fields);
    }

    public int chooseProjectStatus() {
        Object[] statusChoices = {2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderProjects().chooseStatus(), statusChoices);
    }

    public void fixProjectStatusConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilderProjects().fixProjectStatus()); }

    public String chooseTaskToAddToTheProject(Register register) {
        Object[] taskChoices = register.getTasksIds().toArray();
        return getPrint().showInputDialog(getFrame(), getMessageBuilderProjects().chooseTask(), taskChoices);
    }

    public void addedTaskToProjectConfirmation(String chosenTaskToAddToProject, String chosenProject) {
        getPrint().showMessage(getFrame(), getMessageBuilderProjects().addedTaskToProject(chosenTaskToAddToProject, chosenProject));
    }

    public void taskAlreadyInProjectInformation(String chosenTaskToAddToProject, String chosenProject) {
        getPrint().showMessage(getFrame(), getMessageBuilderProjects().taskAlreadyInProject(chosenTaskToAddToProject, chosenProject));
    }

    public int ifAddNext() {
        Object[] statusChoices = {2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderProjects().ifAddNextTask(), statusChoices);
    }

    public String changeProjectDueDate() { return getPrint().inputLine(getFrame(), getMessageBuilderProjects().chooseDueDate()); }

    public void changeDueDateConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilderProjects().changedProjectDueDate()); }

    public void changedProjectTitleConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilderProjects().changedProjectTitle()); }

    public String chooseNewTitleForProject() { return getPrint().inputLine(getFrame(), getMessageBuilderProjects().chooseTitle()); }

    public String enterNewTitleForProject() { return getPrint().inputLine(getFrame(), getMessageBuilderProjects().enterProjectTitle()); }

    public String enterNewDueDateForProject() { return getPrint().inputLine(getFrame(), getMessageBuilderProjects().enterDueDate()); }

    public void addedNewProjectConfirmation(Register register) { getPrint().showMessage(getFrame(), getMessageBuilderProjects().addedProject(register)); }

    public int chooseSortingForProjects() {
        Object[] sortingChoices = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderProjects().chooseProjectsSorting(), sortingChoices);
    }

    public void printSortedProjects(List<Project> sortedProjects) {
        getPrint().showMessage(getFrame(), getMessageBuilderProjects().listOfProjects(sortedProjects));
    }

    public int chooseFilteringForProjects() {
        Object[] filteringChoices = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilderProjects().chooseFiltering(), filteringChoices);
    }

    public void printFilteredProjects(List<Project> filteredProjects) {
        getPrint().showMessage(getFrame(), getMessageBuilderProjects().listOfProjects(filteredProjects));
    }
}
