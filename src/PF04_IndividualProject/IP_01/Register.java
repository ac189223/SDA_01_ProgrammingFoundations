package PF04_IndividualProject.IP_01;

import java.util.ArrayList;
import java.util.Random;

public class Register {
    ArrayList<Task> tasks;
    ArrayList<String> tasksIds;
    ArrayList<Project> projects;
    ArrayList<String> projectsIds;

    Register() {
        this.setTasks(new ArrayList<>());
        this.setTasksIds(new ArrayList<>());
        this.setProjects(new ArrayList<>());
        this.setProjectsIds(new ArrayList<>());
    }

    public ArrayList<Task> getTasks() { return tasks; }
    public ArrayList<String> getTasksIds() {return tasksIds; }
    public ArrayList<Project> getProjects() { return projects; }
    public ArrayList<String> getProjectsIds() {return projectsIds; }

    public void setTasks(ArrayList<Task> tasks) { this.tasks = tasks; }
    public void setTasksIds(ArrayList<String> tasksIds) { this.tasksIds = tasksIds; }
    public void setProjects(ArrayList<Project> projects) { this.projects = projects; }
    public void setProjectsIds(ArrayList<String> projectsIds) { this.projectsIds = projectsIds; }

    public void addTask(Task task) {
        task.setId("task" + randomId(getTasksIds()));
        getTasks().add(task);
        getTasksIds().add(task.getId());
    }

    public void addProject(Project project) {
        project.setId("proj" + randomId(getProjectsIds()));
        getProjects().add(project);
        getProjectsIds().add(project.getId());
    }

    private String randomId(ArrayList<String> listOfIds) {
        Random random = new Random();
        String tempId = String.format("%03d", random.nextInt(1000));
        if (listOfIds.size() != 0)
            while (listOfIds.contains(tempId))
                tempId = String.format("%03d", random.nextInt(1000));
        return tempId;
    }

    public void markTaskAsDone(String id) { findTask(id).setDone(true); }

    public Task findTask(String id) {
        for (Task task: getTasks())
            if (task.getId().equals(id))
                return task;
        return null;
    }

    public void markProjectAsDone(String id) {
        boolean check = true;
        for (Task task: findProject(id).getAssignedTasks()) {
            if (!task.ifDone())
                check = false;
        }
        if (check)
            findProject(id).setDone(true);
        else
            System.out.println("Mark all dependent tasks as done first");
    }

    public Project findProject(String id) {
        for (Project project: getProjects())
            if (project.getId().equals(id))
                return project;
        return null;
    }

    public void addTaskToProject(String taskId, String projectId) {
        findTask(taskId).setAssignedToProject(findProject(projectId));
        findProject(projectId).getAssignedTasks().add(findTask(taskId));
    }

    public void removeTaskFromProject(String taskId) {
        if (findTask(taskId).getAssignedToProject() != null) {
            findTask(taskId).getAssignedToProject().getAssignedTasks().remove(findTask(taskId));
            findTask(taskId).setAssignedToProject(null);
        }
    }

    public void removeAllTasksFromProject(String projectId) {
        ArrayList<Task> assignedTasks = findProject(projectId).getAssignedTasks();
        while (assignedTasks.size() > 0) {
            assignedTasks.get(0).setAssignedToProject(null);
            findProject(projectId).getAssignedTasks().remove(assignedTasks.get(0));
        }
    }

    public void removeTask(String taskId) {
        if (findTask(taskId).getAssignedToProject() != null)
            findTask(taskId).getAssignedToProject().getAssignedTasks().remove(findTask(taskId));
        getTasks().remove(findTask(taskId));
        getTasksIds().remove(taskId);
    }

    public void removeProjectAlways(String projectId) {
        for (Task task: findProject(projectId).getAssignedTasks()) {
            getTasksIds().remove(task.getId());
            getTasks().remove(task);
        }
        getProjectsIds().remove(projectId);
        getProjects().remove(findProject(projectId));
    }

    public void removeProjectDependent(String projectId) {
        if (findProject(projectId).getAssignedTasks().size() == 0) {
            getProjectsIds().remove(projectId);
            getProjects().remove(findProject(projectId));
        } else
            System.out.println("Remove or delete all dependent tasks first");
    }

    public void printStatus() {
        for (Project project: getProjects()) {
            if (project.ifDone())
                System.out.print("(+)");
            else
                System.out.print("(-)");
            System.out.println("  " + project.getId() + ": " + project.getTitle() + " with due date " + project.getDueDate());
            for (Task task : project.getAssignedTasks()) {
                if (task.ifDone())
                    System.out.print("(+)");
                else
                    System.out.print("(-)");
                System.out.println("        " + task.getId() + ": " + task.getTitle() + " with due date " + task.getDueDate());
            }
        }
        for (Task task: getTasks()) {
            if (task.getAssignedToProject() == null) {
                if (task.ifDone())
                    System.out.print("(+)");
                else
                    System.out.print("(-)");
                System.out.println("  " + task.getId() + ": " + task.getTitle() + " with due date " + task.getDueDate());
            }
        }
        System.out.println("==============  =-_-=  ================");
    }
}
