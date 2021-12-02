package JavaException.University;

import java.util.Objects;
import java.util.Set;

public class University {
    private String nameUniversity;
    private Set<Faculty> faculties;

    @Override
    public String toString() {
        return "University{" +
                "nameUniversity='" + nameUniversity + '\'' +
                ", faculties=" + faculties +
                '}';
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(nameUniversity, that.nameUniversity) && Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameUniversity, faculties);
    }

    public University(String nameUniversity, Set<Faculty> faculties) {
        this.nameUniversity = nameUniversity;
        this.faculties = faculties;
    }
}