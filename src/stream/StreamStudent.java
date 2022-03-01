package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StreamStudent {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Paul", 31, 7.5));
        studentList.add(new Student("Max", 27, 7.5));
        studentList.add(new Student("Ramon", 32, 8.1));

        studentList = studentList.stream().filter(element
                -> element.getAge() > 28 && element.getGrade() > 7).toList();
        System.out.println(studentList);

    }

}

class Student {
    private String name;
    private Integer age;
    private Double grade;

    public Student(String name, Integer age, Double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(grade, student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
