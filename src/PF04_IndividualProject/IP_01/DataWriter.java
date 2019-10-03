package PF04_IndividualProject.IP_01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

public class DataWriter {
    public DataWriter() { }

    public void removeOldLines(char lineContent, String fileName)
    {
        try {
            File file = new File(fileName);
            File temp = new File("_temp_");
            PrintWriter out = new PrintWriter(new FileWriter(temp));
            Files.lines(file.toPath())
                    .filter(line -> line.charAt(0) == lineContent)
                    .forEach(out::println);
            out.flush();
            out.close();
            temp.renameTo(file);
        } catch (IOException e) {
            System.out.println("Unable to open " + fileName);
        }
    }

    public void appendNewLines(String fileName, ArrayList<Project> projects, ArrayList<Task> tasks) {
        try {
            File file = new File(fileName);
            PrintWriter out = new PrintWriter(new FileWriter(file));
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
        } catch (IOException e) {
            System.out.println("Unable to open " + fileName);
        }
    }
}
