package Generics.game;

public class TestPlay {
    public static void main(String[] args) {

        Student student1 = new Student("Maximus", 20);
        Student student2 = new Student("Corvus", 22);

        Employee employee1 = new Employee("Sergey", 32);
        Employee employee2 = new Employee("Paul", 30);

        Team<Schoolar> schoolarTeam = new Team<>("Gryffindor");
        schoolarTeam.addNewParticipant(new Schoolar("Harry", 16));
        schoolarTeam.addNewParticipant(new Schoolar("Hermione", 16));
//        schoolarTeam.addNewParticipant(student1);

        Team<Schoolar> schoolarTeam2 = new Team<>("Slytherin");
        schoolarTeam2.addNewParticipant(new Schoolar("Pansy Parkinson", 15));
        schoolarTeam2.addNewParticipant(new Schoolar("Draco Lucius Malfoy", 16));
        System.out.println();

        Team<Student> studentTeam = new Team<>("Fly");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);
        System.out.println();

        Team<Employee> employeeTeam = new Team<>("Rabotyagi");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);
        System.out.println();
//        Team<String> stringTeam = new Team<>("Melody");
//        stringTeam.addNewParticipant(("hello"));

        schoolarTeam.playWith(schoolarTeam2);

    }
}
