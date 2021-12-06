package JavaException.university;

import JavaException.exception.EmptyStudentGroupException;

import java.util.List;

public class Group {
    private final int groupNumber;
    private final List<Student> students;

    public Group(int numberCourse,int numberGroup, List<Student> students) throws EmptyStudentGroupException {
        if(students.isEmpty()){
            throw new EmptyStudentGroupException();
        }
        this.groupNumber = numberCourse * 10 + numberGroup;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber=" + groupNumber +
                ", students=" + students +
                '}';
    }
}
