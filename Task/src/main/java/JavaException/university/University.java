package JavaException.university;

import JavaException.exception.EmptyFacultyUniversityException;
import JavaException.NameFaculty;
import JavaException.Subject;

import java.io.ObjectStreamConstants;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class University {
    private final String nameUniversity;
    private final List<Faculty> faculties;

    public University(String nameUniversity, List<Faculty> faculties) throws EmptyFacultyUniversityException {
        if (faculties.isEmpty()) {
            throw new EmptyFacultyUniversityException();
        }
        this.nameUniversity = nameUniversity;
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "University{" +
                "nameUniversity='" + nameUniversity + '\'' +
                ", faculties=" + faculties +
                '}';
    }

    public List<Faculty> getFaculties() {
        return new ArrayList<>(faculties);
    }

    public double averageScoreAllStudent(int numberStudentCard) {
        return faculties.stream().map(Faculty::getGroups)
                .flatMap(Collection::stream).map(Group::getStudents)
                .flatMap(Collection::stream).filter(s -> s.getIdCard() == numberStudentCard)
                .map(Student::getSubjects).filter(Objects::nonNull).map(s -> s.values()).flatMap(Collection::stream)
                .mapToInt(i -> i).average().getAsDouble();

    }

    public double averageScoreInRequiredSubjectInRequireFacultyAndGroup(NameFaculty requireNameFaculty, int numberGroup, Subject requireSubject) {
        Faculty requireFaculty = faculties.stream().filter(faculty -> faculty.getName().equals(requireNameFaculty))
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
        Group requireGroup = requireFaculty.getGroups().stream().filter(group -> group.getGroupNumber() == numberGroup)
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
        return requireGroup.getStudents().stream().map(Student::getSubjects).map(subject -> subject.get(requireSubject))
                .filter(Objects::nonNull).mapToInt(i -> i).average().getAsDouble();

    }

    public double averageScoreInRequiredSubjectInAllUniversity(Subject requiredSubject) {
        return faculties.stream().map(Faculty::getGroups).flatMap(Collection::stream).map(Group::getStudents)
                .flatMap(Collection::stream).map(Student::getSubjects).map(s -> s.get(requiredSubject))
                .filter(Objects::nonNull).mapToInt(i -> i).average().getAsDouble();

    }
}