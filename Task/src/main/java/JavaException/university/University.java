package JavaException.university;

import JavaException.exception.EmptyFacultyUniversityException;
import JavaException.NameFaculty;
import JavaException.Subject;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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
        return faculties;
    }

    public double averageScoreAllStudent(int numberStudentCard) {
        Stream<Student> stream = this.getFaculties().stream().map(Faculty::getGroups)
                .flatMap(Collection::stream).map(Group::getStudents)
                .flatMap(Collection::stream).filter(s -> s.getIdCard() == numberStudentCard);
        stream.findFirst().orElseThrow(() -> new IllegalArgumentException());
        Stream<Map.Entry<Subject, Integer>> entryStream = stream.map(Student::getSubjects).map(s -> s.entrySet()).flatMap(Collection::stream);
        int sum = entryStream.mapToInt(s -> s.getValue()).sum();
        double countSubject = entryStream.count();
        if (countSubject > 0) {
            return sum / countSubject;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double averageScoreInRequiredSubjectInRequireFacultyAndGroup(NameFaculty requireNameFaculty, int numberGroup, Subject requireSubject) {
        Faculty requireFaculty = this.getFaculties().stream().filter(faculty -> faculty.getName().equals(requireNameFaculty))
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
        Group requireGroup = requireFaculty.getGroups().stream().filter(group -> group.getGroupNumber() == numberGroup)
                .findFirst().orElseThrow(() -> new IllegalArgumentException());

        Stream<Map.Entry<Subject, Integer>> stream = requireGroup.getStudents().stream().map(Student::getSubjects).map(subject -> subject.entrySet())
                .flatMap(Collection::stream).filter(s -> s.getKey().equals(requireSubject));
        int sum = stream.mapToInt(s -> s.getValue()).sum();
        double countSubject = stream.count();
        if (countSubject > 0) {
            return sum / countSubject;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double averageScoreInRequiredSubjectInAllUniversity(Subject requiredSubject) {
        Stream<Map.Entry<Subject, Integer>> stream = this.getFaculties().stream().map(Faculty::getGroups).flatMap(Collection::stream).map(Group::getStudents)
                .flatMap(Collection::stream).map(Student::getSubjects).map(subject -> subject.entrySet())
                .flatMap(Collection::stream).filter(entrySubject -> entrySubject.getKey() == requiredSubject);
        stream.findFirst().orElseThrow(() -> new IllegalArgumentException());
        double countSubject = stream.count();
        int sum = stream.mapToInt(entrySubject -> entrySubject.getValue()).sum();
        if (countSubject > 0) {
            return sum / countSubject;
        } else {
            throw new IllegalArgumentException();
        }
    }
}