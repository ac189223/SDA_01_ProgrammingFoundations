package PF04_IndividualProject.IP_01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataReader {
    private static final int NUMBER_OF_FIELDS_EXPECTED = 5;
    private static final int ID = 0,
            TITLE = 1,
            DUE_DATE = 2,
            DONE = 3,
            ASSIGNATION = 4;

    public DataReader() { }

    // Read data from file
    public ReadedLists getData(String filename)
    {
        // Create projects from a CSV input line.
        Function<String, Project> createProject =
                record -> {
                    String[] parts = record.split(",");
                    if(parts.length == NUMBER_OF_FIELDS_EXPECTED || parts.length == (NUMBER_OF_FIELDS_EXPECTED - 1)) {
                        String id = parts[ID].trim();
                        String title = parts[TITLE].trim();
                        String dueDate = parts[DUE_DATE].trim();
                        boolean done = true;
                        if (parts[DONE].trim().equals("false"))
                            done = false;
                        if (parts.length == NUMBER_OF_FIELDS_EXPECTED) {
                            String assignedTasks = parts[ASSIGNATION].trim();
                            return new Project(id, title, dueDate, done, assignedTasks);
                        } else {
                            return new Project(id, title, dueDate, done);
                        }
                    }
                    else {
                        System.out.println("Record has the wrong number of fields: " + record);
                        return null;
                    }
                };

        // Create tasks from a CSV input line.
        Function<String, Task> createTask =
                record -> {
                    String[] parts = record.split(",");
                    if(parts.length == NUMBER_OF_FIELDS_EXPECTED || parts.length == (NUMBER_OF_FIELDS_EXPECTED - 1)) {
                        String id = parts[ID].trim();
                        String title = parts[TITLE].trim();
                        String dueDate = parts[DUE_DATE].trim();
                        boolean done = true;
                        if (parts[DONE].trim().equals("false"))
                            done = false;
                        if (parts.length == NUMBER_OF_FIELDS_EXPECTED) {
                            String assignedToProject = parts[ASSIGNATION].trim();
                            return new Task(id, title, dueDate, done, assignedToProject);
                        } else {
                            return new Task(id, title, dueDate, done);
                        }
                    }
                    else {
                        System.out.println("Record has the wrong number of fields: " + record);
                        return null;
                    }
                };

        ArrayList<Task> tasks;
        ArrayList<Project> projects;
        try {
            projects = Files.lines(Paths.get(filename))
                    .filter(record -> record.length() > 0 && record.charAt(0) == 'p' )
                    .map(createProject)
                    .filter(project -> project != null)
                    .collect(Collectors.toCollection(ArrayList::new));
            tasks = Files.lines(Paths.get(filename))
                    .filter(record -> record.length() > 0 && record.charAt(0) == 't' )
                    .map(createTask)
                    .filter(task -> task != null)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        catch(IOException e) {
            System.out.println("Unable to open " + filename);
            tasks = new ArrayList<>();
            projects = new ArrayList<>();
        }

        ArrayList<String> tasksIds = new ArrayList<>();
        tasks.stream().forEach(task -> tasksIds.add(task.getId()));
        ArrayList<String> projectsIds = new ArrayList<>();
        projects.stream().forEach(project -> projectsIds.add(project.getId()));

        return new ReadedLists(tasks, tasksIds, projects, projectsIds);
    }
}
