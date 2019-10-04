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

    public ArrayList<String> removeOldLines(char lineContent, String fileName)
    {
        try {
            File file = new File(fileName);
            File temp = new File("_temp_");
            PrintWriter out = new PrintWriter(new FileWriter(temp));
//            Files.lines(file.toPath())
  //                  .filter(record -> record.charAt(0) == 'd')
    //                .forEach(out::println);

            ArrayList<String> descriptions;
            descriptions = Files.lines(file.toPath())
                    .filter(record -> record.charAt(0) == 'd')
                    .collect(Collectors.toCollection(ArrayList::new));

            out.flush();
            out.close();
            temp.renameTo(file);
            return descriptions;
        } catch (IOException e) {
            System.out.println("Unable to open " + fileName);
            return null;
        }
    }

    public void appendNewLines(String fileName, ArrayList<String> descriptions, ArrayList<Project> projects, ArrayList<Task> tasks) {
        try {
            File file = new File(fileName);
            PrintWriter out = new PrintWriter(new FileWriter(file));
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
        } catch (IOException e) {
            System.out.println("Unable to open " + fileName);
        }
    }
}
