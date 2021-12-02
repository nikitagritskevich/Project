package JavaException.University;

import JavaException.NameFaculty;

import java.util.Objects;
import java.util.Set;

public class Faculty {
    private final NameFaculty name;
    private final Set<Group> groups;
    public Faculty(NameFaculty name, Set<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return name == faculty.name && Objects.equals(groups, faculty.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groups);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name=" + name +
                ", groups=" + groups +
                '}';
    }
}
