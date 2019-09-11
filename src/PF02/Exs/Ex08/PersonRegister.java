package PF02.Exs.Ex08;

import java.util.ArrayList;

public class PersonRegister {
    private ArrayList<Person> people = new ArrayList<>();

    public PersonRegister(ArrayList<Person> people) { this.people = people; }

    public ArrayList<Person> getPeople() { return people; }

    public void setPeople(ArrayList<Person> people) { this.people = people; }

    public void addPerson(Person person) { getPeople().add(person); }

    public Person find(String pNbr) {
        for (Person person : getPeople())
            if (person.getpNbr().equals(pNbr))
                return person;
        return null;
    }

    public void remove(String pNbr) { getPeople().remove(find(pNbr)); }
}
/*
Class: PersonRegister:
 add method, find method, remove method
 */