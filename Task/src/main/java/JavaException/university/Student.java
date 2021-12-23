package JavaException.university;

import JavaException.exception.IncorrectSubjectScoreException;
import JavaException.exception.EmptyStudentSubjectException;
import JavaException.Subject;


import java.util.HashMap;
import java.util.Map;


public class Student {
    private final String name;
    private final String lastName;
    private final String surName;
    private final int idCard;
    private final Map<Subject, Integer> subjects;

    public Student(String name, String lastName, String surName, int idCard, Map<Subject, Integer> subjects) throws IncorrectSubjectScoreException, EmptyStudentSubjectException {
        if (subjects.isEmpty()) {
            throw new EmptyStudentSubjectException();
        }
        if (subjects.entrySet().stream().anyMatch(s -> s.getValue() < 0 || s.getValue() > 10)) {
            throw new IncorrectSubjectScoreException();
        }
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.idCard = idCard;
        this.subjects = subjects;
    }

    public int getIdCard() {
        return idCard;
    }

    public Map<Subject, Integer> getSubjects() {
        return new HashMap<>(subjects);
    }

    @Override
    public String toString() {
        return "Student{" +
                surName + " " +
                name.toUpperCase().charAt(0) + '.' +
                lastName.toUpperCase().charAt(0) + '.' +
                ", idCard:= " + idCard + ", subject:= " + subjects +
                '}';
    }
}
