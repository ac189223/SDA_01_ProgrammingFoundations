package PF02.Quiz;

import java.util.ArrayList;

public class LabClass {

    private ArrayList<String> register;

    public LabClass() {
        register = new ArrayList<>();
    }

    public void addStudentName(String name) {
        register.add(name);
    }

    public String toString() {
        String list = "";
        for(String name :register){
            list += name + "\n";
        }
        return list;
    }
}