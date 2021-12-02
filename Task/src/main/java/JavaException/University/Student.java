package JavaException.University;

import JavaException.Subject;


import java.util.Map;
import java.util.Objects;

public class Student {
    private final String name;
    private final String lastName;
    private final String surName;
    private int idCard;
    private final Map<Subject,Integer> subjects;

    public Student(String name, String lastName, String surName, int idCard, Map<Subject, Integer> subjects) {
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.idCard = idCard;
        this.subjects = subjects;
    }

    public Map<Subject, Integer> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                surName + " " +
                name.toUpperCase().charAt(0) + '.' +
                lastName.toUpperCase().charAt(0) + '.' +
                ", idCard:= " + idCard + ", subject:= "+ subjects +
                '}';
    }
}
