package PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Controller;

import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Register;
import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.View.Print;

import javax.swing.*;

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

    /** =================    =================    Popups    =================   ================= */

    // Popup for main menu
    public int mainChoice(Register register) {
        Object[] mains = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilder().chooseMain(register), mains);
    }

    // Confirmation popups
    public void saveConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilder().saveDataConfirmation()); }

    public void addedTaskToProjectConfirmation(String chosenTaskToAddToProject, String chosenProject) {
        getPrint().showMessage(getFrame(), getMessageBuilder().addedTaskToProjectConfirmation(chosenTaskToAddToProject, chosenProject));
    }

    // Information popups
    public void noProjectsInfo() { getPrint().showMessage(getFrame(), getMessageBuilder().noProjectsInfo()); }

    public void noTasksInfo() {
        getPrint().showMessage(getFrame(), getMessageBuilder().noProjectsInfo());
    }

    public void noTasksNoProjectsInfo() {
        getPrint().showMessage(getFrame(), getMessageBuilder().noTasksNoProjects());
    }

    public void taskAlreadyInProjectInformation(String chosenTaskToAddToProject, String chosenProject) {
        getPrint().showMessage(getFrame(), getMessageBuilder().taskAlreadyInProjectInfo(chosenTaskToAddToProject, chosenProject));
    }

    //  Popup with list printed out from main menu
    public void mainTasksAndProjectsList(Register register) { getPrint().showMessage(getFrame(), getMessageBuilder().listForMain(register));
    }
}