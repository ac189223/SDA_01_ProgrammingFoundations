package PF04_IndividualProject.IP_01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DataWriter {
    public DataWriter() { }

    public ArrayList<String> chooseLinesToKeep(char lineContent, String fileName)
    {
        try {
            ArrayList<String> descriptions;
            descriptions = Files.lines(Paths.get(fileName))
                    .filter(record -> record.charAt(0) == lineContent)
                    .collect(Collectors.toCollection(ArrayList::new));
            return descriptions;
        } catch (IOException e) {
            System.out.println("Unable to open " + fileName);
            return null;
        }
    }

    public void appendNewLines(String fileName, ArrayList<String> descriptions, ArrayList<Project> projects, ArrayList<Task> tasks) {
        try {
            File file = new File(fileName);
            File temp = new File("_temp_");
            PrintWriter out = new PrintWriter(new FileWriter(temp));
            descriptions.forEach(out::println);
            projects.stream()
                    .map(project -> project.getId() + "," + project.getTitle() + "," +
                            project.getDueDate() + "," + project.ifDone()+ ",")
                    .forEach(out::println);
            tasks.stream()
                    .map(task -> task.getId() + "," + task.getTitle() + "," +
                            task.getDueDate() + "," + task.ifDone()+ "," + task.getAssignedToProject())
                    .forEach(out::println);
            out.flush();
            out.close();
            temp.renameTo(file);
        } catch (IOException e) {
            System.out.println("Unable to open " + fileName);
        }
    }
}
