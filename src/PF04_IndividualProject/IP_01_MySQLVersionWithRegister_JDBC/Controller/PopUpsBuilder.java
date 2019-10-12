package PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Controller;

import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Register;
import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.View.Print;

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

    /** =================    =================    Main popups    =================   ================= */

    public int mainChoice(Register register) {
        Object[] mains = {4, 3, 2, 1};
        return getPrint().showOptionDialog(getFrame(), getMessageBuilder().chooseMain(register), mains);
    }

    public void saveConfirmation() { getPrint().showMessage(getFrame(), getMessageBuilder().saveDataConfirmation()); }

    public void noProjectsInfo() { getPrint().showMessage(getFrame(), getMessageBuilder().noProjectsInfo()); }

    public void noTasksInfo() {
        getPrint().showMessage(getFrame(), getMessageBuilder().noProjectsInfo());
    }

    public void noTasksNoProjectsInfo() {
        getPrint().showMessage(getFrame(), getMessageBuilder().noTasksNoProjects());
    }

    public void mainTasksAndProjectsList(Register register) { getPrint().showMessage(getFrame(), getMessageBuilder().listForMain(register));
    }

    public void addedTaskToProjectConfirmation(String chosenTaskToAddToProject, String chosenProject) {
        getPrint().showMessage(getFrame(), getMessageBuilder().addedTaskToProjectConfirmation(chosenTaskToAddToProject, chosenProject));
    }

    public void taskAlreadyInProjectInformation(String chosenTaskToAddToProject, String chosenProject) {
        getPrint().showMessage(getFrame(), getMessageBuilder().taskAlreadyInProjectInfo(chosenTaskToAddToProject, chosenProject));
    }


}
