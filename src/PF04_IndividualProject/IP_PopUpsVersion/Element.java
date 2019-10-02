package PF04_IndividualProject.IP_PopUpsVersion;

import java.util.ArrayList;
import java.util.Random;

public class Element {
    private String id;
    private String title;
    private String dueDate;
    private boolean done;

    public Element(String title, String dueDate) {
        this.setTitle(title);
        this.setDueDate(dueDate);
        this.setDone(false);
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDueDate() { return dueDate; }
    public boolean ifDone() { return done; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public void setDone(boolean done) { this.done = done; }

    public String randomId() {
        Random random = new Random();
        return String.format("%03d", random.nextInt(1000));
    }

    public String checkedRandomId(Object[] listOfId) {
        Random random = new Random();
        String tempId = "";
        do {
            tempId = String.format("%03d", random.nextInt(1000));
        } while (!notContains(listOfId, tempId));
        return null;
    }

    private boolean notContains(Object[] listOfId, String tempId) {
        for (Object id: listOfId)
            if (String.valueOf(id).equals(tempId))
                return false;
        return true;
    }
}
