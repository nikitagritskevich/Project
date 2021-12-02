package JavaException;

import JavaException.University.Faculty;
import JavaException.University.Group;
import JavaException.University.Student;
import JavaException.University.University;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        Map<Subject, Integer> subject = new HashMap<>();
        Set<Group> groupsBiologyFaculty = new HashSet<>();
        Set<Group> groupsMathFaculty = new HashSet<>();
        Set<Faculty> faculties = new HashSet<>();
        subject.put(Subject.ENGLISH, 3);
        subject.put(Subject.HIGH_MATH, 10);
        students.add(new Student("Valentin", "Sergeevich", "Burikov", 1231, subject));
        subject = new HashMap<>();
        subject.put(Subject.ENGLISH, 3);
        subject.put(Subject.HIGH_MATH, 7);
        students.add(new Student("Maksim", "Andreevich", "Petrov", 1232, subject));
        subject = new HashMap<>();
        subject.put(Subject.ENGLISH, 5);
        subject.put(Subject.HIGH_MATH, 8);
        students.add(new Student("Andry", "Nikitivich", "Sidorov", 1233, subject));
        subject = new HashMap<>();
        subject.put(Subject.ENGLISH, 1);
        subject.put(Subject.HIGH_MATH, 1);
        students.add(new Student("Jack", "Burikov", "Vladislavovich", 1234, subject));
        groupsMathFaculty.add(new Group(1, 2, students));
        students.clear();
        subject.clear();
        subject.put(Subject.BIOLOGY, 3);
        subject.put(Subject.ECOLOGY, 10);
        subject.put(Subject.HISTORY, 4);
        students.add(new Student("Ira", "Sergeevna", "Sifons", 1254121, subject));
        subject = new HashMap<>();
        subject.put(Subject.BIOLOGY, 7);
        subject.put(Subject.ECOLOGY, 3);
        subject.put(Subject.HISTORY, 4);
        students.add(new Student("Juli", "Andreevna", "Konkova", 1254122, subject));
        subject = new HashMap<>();
        subject.put(Subject.BIOLOGY, 9);
        subject.put(Subject.ECOLOGY, 1);
        subject.put(Subject.HISTORY, 7);
        students.add(new Student("Jack", "Kirilovich", "Gritskevich", 1254123, subject));
        subject = new HashMap<>();
        subject.put(Subject.BIOLOGY, 7);
        subject.put(Subject.ECOLOGY, 6);
        subject.put(Subject.HISTORY, 9);
        students.add(new Student("Jack", "Burikov", "Timofeevich", 1254124, subject));
        groupsBiologyFaculty.add(new Group(3, 2, students));
        students.clear();
        subject.clear();

        subject.put(Subject.ENGLISH, 7);
        subject.put(Subject.HIGH_MATH, 8);
        subject.put(Subject.PHYSIC, 10);
        students.add(new Student("Petr", "Vitaleevich", "Vorobev", 1238121, subject));
        subject = new HashMap<>();
        subject.put(Subject.ENGLISH, 7);
        subject.put(Subject.HIGH_MATH, 10);
        subject.put(Subject.PHYSIC, 5);
        students.add(new Student("Valentin", "Kirilovich", "Podoksenov", 1238126, subject));
        subject = new HashMap<>();
        subject.put(Subject.ENGLISH, 5);
        subject.put(Subject.HIGH_MATH, 8);
        subject.put(Subject.PHYSIC, 7);
        students.add(new Student("Kiril", "Andreevich", "Marzenkevich", 1238127, subject));
        subject = new HashMap<>();
        subject.put(Subject.ENGLISH, 1);
        subject.put(Subject.HIGH_MATH, 1);
        subject.put(Subject.PHYSIC, 1);
        students.add(new Student("Marat", "Sergeevich", "Molhozov", 1238128, subject));
        groupsMathFaculty.add(new Group(1, 3, students));
        students.clear();
        subject.clear();
        subject.put(Subject.BIOLOGY, 3);
        subject.put(Subject.ECOLOGY, 10);
        subject.put(Subject.HISTORY, 4);
        subject.put(Subject.SOCIOLOGY, 1);
        students.add(new Student("Anton", "Vladimirovich", "Atroshkevich", 32254121, subject));
        subject = new HashMap<>();
        subject.put(Subject.BIOLOGY, 7);
        subject.put(Subject.ECOLOGY, 3);
        subject.put(Subject.HISTORY, 4);
        subject.put(Subject.SOCIOLOGY, 5);
        students.add(new Student("Juli", "Sergeevna", "Bogdanovich", 32254122, subject));
        subject = new HashMap<>();
        subject.put(Subject.BIOLOGY, 9);
        subject.put(Subject.ECOLOGY, 1);
        subject.put(Subject.HISTORY, 7);
        subject.put(Subject.SOCIOLOGY, 9);
        students.add(new Student("Maksim", "Igorevich", "Letuchy", 32254123, subject));
        subject = new HashMap<>();
        subject.put(Subject.BIOLOGY, 7);
        subject.put(Subject.ECOLOGY, 6);
        subject.put(Subject.HISTORY, 9);
        subject.put(Subject.SOCIOLOGY, 10);
        students.add(new Student("Dmitry", "Dmitrievich", "Spiridonov", 32254124, subject));
        groupsBiologyFaculty.add(new Group(7, 5, students));
        faculties.add(new Faculty(NameFaculty.MATH, groupsMathFaculty));
        faculties.add(new Faculty(NameFaculty.BIOLOGY, groupsBiologyFaculty));
        University university = new University("Masherova",faculties);
        try (Scanner in = new Scanner(System.in)) {


        }
    }
}
