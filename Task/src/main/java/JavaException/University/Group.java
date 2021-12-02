package JavaException.University;

import java.util.Objects;
import java.util.Set;

public class Group {
    private final int numberGroup;
    private int numberCourse;
    private final Set<Student> students;

    public Group(int numberGroup, int numberCourse, Set<Student> students) {
        this.numberGroup = numberGroup;
        this.numberCourse = numberCourse;
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return numberGroup == group.numberGroup && numberCourse == group.numberCourse && students.equals(group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberGroup, numberCourse, students);
    }

    @Override
    public String toString() {
        return "Group{" +
                numberCourse + numberGroup + " groups" +
                ", students=" + students +
                '}';
    }
}
