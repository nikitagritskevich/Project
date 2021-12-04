package JavaException.University;

import JavaException.NameFaculty;
import JavaException.Subject;

import java.util.Collection;
import java.util.List;

public class University {
    private String nameUniversity;
    private List<Faculty> faculties;

    public University(String nameUniversity, List<Faculty> faculties) {
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

    public int sumAllStudentScore(int numberStudentCard) {
        Student student = this.getFaculties().stream().map(Faculty::getGroups)
                .flatMap(Collection::stream).map(Group::getStudents)
                .flatMap(Collection::stream).filter(s -> s.getIdCard() == numberStudentCard).findFirst().orElseThrow(() -> new IllegalArgumentException());

        return student.getSubjects().entrySet().stream().mapToInt(s -> s.getValue()).sum();
    }

    public double averageScoreInRequiredSubjectInRequireFacultyAndGroup(NameFaculty requireNameFaculty, int numberGroup, Subject requireSubject) {
        Faculty requireFaculty = this.getFaculties().stream().filter(faculty -> faculty.getName().equals(requireNameFaculty))
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
        Group requireGroup = requireFaculty.getGroups().stream().filter(group -> group.getGroupNumber() == numberGroup)
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
        int sum = requireGroup.getStudents().stream().map(Student::getSubjects).map(subject -> subject.entrySet())
                .flatMap(Collection::stream).filter(s -> s.getKey().equals(requireSubject))
                .mapToInt(s -> s.getValue()).sum();
        double countSubject = requireGroup.getStudents().stream().map(Student::getSubjects).map(subject -> subject.entrySet())
                .flatMap(Collection::stream).filter(s -> s.getKey().equals(requireSubject)).count();
        return sum / countSubject;
    }
    public double averageScoreInRequiredSubjectInAllUniversity(Subject requiredSubject){
        this.getFaculties().stream().map(Faculty::getGroups).flatMap(Collection::stream).map(Group::getStudents)
                .flatMap(Collection::stream).map(Student::getSubjects).map(subject->subject.entrySet())
                .flatMap(Collection::stream).filter(entrySubject -> entrySubject.getKey() == requiredSubject).findFirst()
                .orElseThrow(()->new IllegalArgumentException());
        double countSubject = this.getFaculties().stream().map(Faculty::getGroups).flatMap(Collection::stream).map(Group::getStudents)
                .flatMap(Collection::stream).map(Student::getSubjects).map(subject->subject.entrySet())
                .flatMap(Collection::stream).filter(entrySubject -> entrySubject.getKey() == requiredSubject).count();
        int sum = this.getFaculties().stream().map(Faculty::getGroups).flatMap(Collection::stream).map(Group::getStudents)
                .flatMap(Collection::stream).map(Student::getSubjects).map(subject->subject.entrySet())
                .flatMap(Collection::stream).filter(entrySubject -> entrySubject.getKey() == requiredSubject)
                .mapToInt(entrySubject ->entrySubject.getValue()).sum();
        return sum/countSubject;
    }
}