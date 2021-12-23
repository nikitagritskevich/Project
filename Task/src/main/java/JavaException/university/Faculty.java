package JavaException.university;

import JavaException.exception.EmptyGroupUniversityException;
import JavaException.NameFaculty;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final NameFaculty name;
    private final List<Group> groups;

    public Faculty(NameFaculty name, List<Group> groups) throws EmptyGroupUniversityException {
        if (groups.isEmpty()) {
            throw new EmptyGroupUniversityException();
        }
        this.name = name;
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return new ArrayList<>(groups);
    }

    public NameFaculty getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name=" + name +
                ", groups=" + groups +
                '}';
    }
}
