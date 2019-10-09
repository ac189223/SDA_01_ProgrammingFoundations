package PF04_IndividualProject.IP_01.Controller;

import PF04_IndividualProject.IP_01.Model.Register;
import PF04_IndividualProject.IP_01.View.Print;

import javax.swing.*;

public class PopUpsBuilderTasks extends PopUpsBuilder{
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

    public void addedNewTaskConfirmation(Register register) { getPrint().showMessage(getFrame(), getMessageBuilderTasks().addedTask(register)); }

}
