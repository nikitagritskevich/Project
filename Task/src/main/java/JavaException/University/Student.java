package JavaException.University;

import JavaException.Exception.InCorrectSubjectScoreException;
import JavaException.Exception.NoSuchStudentForSubjectException;
import JavaException.Subject;


import java.util.Map;


public class Student {
    private final String name;
    private final String lastName;
    private final String surName;
    private final int idCard;
    private final Map<Subject, Integer> subjects;

    public Student(String name, String lastName, String surName, int idCard, Map<Subject, Integer> subjects) throws InCorrectSubjectScoreException, NoSuchStudentForSubjectException {
        if (subjects.isEmpty()) {
            throw new NoSuchStudentForSubjectException();
        }
        if (!subjects.entrySet().stream().allMatch(s -> s.getValue() > 0 || s.getValue() < 10)) {
            throw new InCorrectSubjectScoreException();
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
        return subjects;
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
