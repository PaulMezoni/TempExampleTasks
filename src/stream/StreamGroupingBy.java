package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupingBy {
    public static void main(String[] args) {
        Student student = new Student("Paul", 31, 7.5);
        Student student2 = new Student("Max", 30, 8.5);
        Student student3 = new Student("Svea", 29, 9.5);
        Student student4 = new Student("Kubuntu", 30, 7.5);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        Map<Object, List<Student>> collect = studentList.stream()
                .peek(e -> e.setName(e.getName().toUpperCase()))
                .collect(Collectors.groupingBy(e -> e.getAge()));
        for (Map.Entry<Object, List<Student>> entry : collect.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }

        System.out.println(" - - - ");

        Map<Boolean, List<Student>> collectPartition = studentList.stream()
                .collect(Collectors.partitioningBy(e -> e.getGrade() > 7.5));
        for (Map.Entry<Boolean, List<Student>> entry : collectPartition.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }
}
