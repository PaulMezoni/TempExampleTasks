package stream;

import java.util.ArrayList;
import java.util.List;

public class StreamFlatMap {
    public static void main(String[] args) {
        Student student = new Student("Paul", 31, 7.5);
        Student student2 = new Student("Max", 30, 8.5);
        Student student3 = new Student("Svea", 29, 9.5);
        Student student4 = new Student("Kubuntu", 30, 6.5);

        Faculty f1 = new Faculty("Economics");
        Faculty f2 = new Faculty("Biology");

        f1.addStudentsOnFaculty(student);
        f1.addStudentsOnFaculty(student2);
        f2.addStudentsOnFaculty(student3);
        f2.addStudentsOnFaculty(student4);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);

        facultyList.stream().flatMap(e -> e.getStudentOnFaculty().stream()).forEach(e -> System.out.println(e.getName()));
    }

}

class Faculty {
    private final String name;
    private final List<Student> studentOnFaculty;

    public Faculty(String name) {
        this.name = name;
        this.studentOnFaculty = new ArrayList<>();
    }

    public List<Student> getStudentOnFaculty() {
        return studentOnFaculty;
    }

    public void addStudentsOnFaculty(Student st) {
        studentOnFaculty.add(st);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", studentOnFaculty=" + studentOnFaculty +
                '}';
    }
}
