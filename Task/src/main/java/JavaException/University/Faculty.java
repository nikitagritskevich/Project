package JavaException.University;

import JavaException.NameFaculty;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Faculty  {
    private final NameFaculty name;
    private final List<Group> groups;

    public Faculty(NameFaculty name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
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
