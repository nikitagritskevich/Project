package JavaException;

import JavaException.exception.*;
import JavaException.university.Faculty;
import JavaException.university.Group;
import JavaException.university.Student;
import JavaException.university.University;

import java.util.*;

public class Runner {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            University university = fillInUniversity();
            System.out.println(university);
            System.out.println("Input number id Student Card :");
            int numberStudentCard = in.nextInt();
            System.out.println("sum score required Student is := " + university.averageScoreAllStudent(numberStudentCard));
            System.out.println("Input name Faculty :");
            NameFaculty requireFaculty = NameFaculty.valueOf(in.next().toUpperCase());
            System.out.println("Input number Group :");
            int groupNumber = in.nextInt();
            System.out.println("Input name Subject :");
            Subject requireSubject = Subject.valueOf(in.next().toUpperCase());
            System.out.println("The average score " + university.averageScoreInRequiredSubjectInRequireFacultyAndGroup(requireFaculty, groupNumber, requireSubject)
                    + " in " + requireFaculty + " faculty, in a group with number: " + groupNumber +
                    ", by Subject " + requireSubject);
            System.out.println("Input name Subject :");


            requireSubject = Subject.valueOf(in.next().toUpperCase());
            System.out.println("The average score in all university is =" + university.averageScoreInRequiredSubjectInAllUniversity(requireSubject)
                    + " by subject : " + requireSubject);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IncorrectSubjectScoreException e) {
            e.printStackTrace();
        } catch (EmptyStudentSubjectException e) {
            e.printStackTrace();
        } catch (EmptyStudentGroupException e) {
            e.printStackTrace();
        } catch (EmptyGroupUniversityException e) {
            e.printStackTrace();
        }catch (EmptyFacultyUniversityException e){
            e.printStackTrace();
        }

    }


    private static University fillInUniversity() throws IncorrectSubjectScoreException,
            EmptyStudentSubjectException,
            EmptyStudentGroupException,
            EmptyGroupUniversityException,
            EmptyFacultyUniversityException {


        List<Student> students = new ArrayList<>();

        List<Group> groupsBiologyFaculty = new ArrayList<>();
        List<Group> groupsMathFaculty = new ArrayList<>();
        List<Faculty> faculties = new ArrayList<>();
        Map<Subject, Integer> subject = Map.of(Subject.ENGLISH, 5, Subject.HIGH_MATH, 10);
        students.add(new Student("Valentin", "Sergeevich", "Burikov", 1231, subject));
        subject = Map.of(Subject.ENGLISH, 3, Subject.HIGH_MATH, 7);

        students.add(new Student("Maksim", "Andreevich", "Petrov", 1232, subject));
        subject = Map.of(Subject.ENGLISH, 5, Subject.HIGH_MATH, 8);
        students.add(new Student("Andry", "Nikitivich", "Sidorov", 1233, subject));
        subject = Map.of(Subject.ENGLISH, 1, Subject.HIGH_MATH, 1);
        students.add(new Student("Jack", "Burikov", "Vladislavovich", 1234, subject));
        groupsMathFaculty.add(new Group(2, 1, students));
        students = new ArrayList<>();


        subject = Map.of(Subject.BIOLOGY, 3, Subject.ECOLOGY, 10, Subject.HISTORY, 4);
        students.add(new Student("Ira", "Sergeevna", "Sifons", 1254121, subject));
        subject = Map.of(Subject.BIOLOGY, 7, Subject.ECOLOGY, 3, Subject.HISTORY, 4);
        students.add(new Student("Juli", "Andreevna", "Konkova", 1254122, subject));
        subject = Map.of(Subject.BIOLOGY, 9, Subject.ECOLOGY, 1, Subject.HISTORY, 7);
        students.add(new Student("Jack", "Kirilovich", "Gritskevich", 1254123, subject));
        subject = Map.of(Subject.BIOLOGY, 7, Subject.ECOLOGY, 6, Subject.HISTORY, 9);
        students.add(new Student("Jack", "Burikov", "Timofeevich", 1254124, subject));
        groupsBiologyFaculty.add(new Group(3, 2, students));
        students = new ArrayList<>();
        subject = Map.of(Subject.ENGLISH, 7, Subject.HIGH_MATH, 8, Subject.PHYSIC, 10);
        students.add(new Student("Petr", "Vitaleevich", "Vorobev", 1238121, subject));
        subject = Map.of(Subject.ENGLISH, 7, Subject.HIGH_MATH, 10, Subject.PHYSIC, 5);
        students.add(new Student("Valentin", "Kirilovich", "Podoksenov", 1238126, subject));
        subject = Map.of(Subject.ENGLISH, 5, Subject.HIGH_MATH, 8, Subject.PHYSIC, 7);
        students.add(new Student("Kiril", "Andreevich", "Marzenkevich", 1238127, subject));
        subject = Map.of(Subject.ENGLISH, 1, Subject.HIGH_MATH, 1, Subject.PHYSIC, 1);
        students.add(new Student("Marat", "Sergeevich", "Molhozov", 1238128, subject));
        groupsMathFaculty.add(new Group(1, 3, students));
        students = new ArrayList<>();
        subject = Map.of(Subject.BIOLOGY, 3, Subject.ECOLOGY, 10, Subject.HISTORY, 4, Subject.SOCIOLOGY, 1);
        students.add(new Student("Anton", "Vladimirovich", "Atroshkevich", 32254121, subject));
        subject = Map.of(Subject.BIOLOGY, 7, Subject.ECOLOGY, 3, Subject.HISTORY, 4, Subject.SOCIOLOGY, 5);
        students.add(new Student("Juli", "Sergeevna", "Bogdanovich", 32254122, subject));
        subject = Map.of(Subject.BIOLOGY, 9, Subject.ECOLOGY, 1, Subject.HISTORY, 7, Subject.SOCIOLOGY, 9);
        students.add(new Student("Maksim", "Igorevich", "Letuchy", 32254123, subject));
        subject = Map.of(Subject.BIOLOGY, 7, Subject.ECOLOGY, 6, Subject.HISTORY, 9, Subject.SOCIOLOGY, 10);

        students.add(new Student("Dmitry", "Dmitrievich", "Spiridonov", 32254124, subject));
        groupsBiologyFaculty.add(new Group(4, 5, students));
        faculties.add(new Faculty(NameFaculty.MATH, groupsMathFaculty));
        faculties.add(new Faculty(NameFaculty.BIOLOGY, groupsBiologyFaculty));
        return new University("Masherova", faculties);
    }
}
