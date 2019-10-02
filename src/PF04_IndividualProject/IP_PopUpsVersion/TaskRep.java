package PF04_IndividualProject.IP_PopUpsVersion;

import java.util.ArrayList;

public class TaskRep {
    private ArrayList<Task> tasks;

    public TaskRep() { this.setTasks(new ArrayList<>()); }
    public TaskRep(ArrayList<Task> tasks) { this.setTasks(tasks); }

    public ArrayList<Task> getTasks() { return tasks; }
    public void setTasks(ArrayList<Task> tasks) { this.tasks = tasks; }
    public void addTask(Task task) { this.getTasks().add(task); }

    public boolean notContains(String tempId) {
        for (Object id: getTasks().stream().map(task -> task.getId().substring(task.getId().length()-3)).toArray())
            if (String.valueOf(id).equals(tempId))
                return false;
        return true;
    }
}
