package src;

public class Student {
    String name; // Instance variable
    static int studentCount = 0; // Static variable

    public Student(String name){
        this.name=name;
        studentCount++;
    }

    static void main() {
        Student s1 = new Student("Will");
        System.out.println(s1.studentCount);
        Student s2 = new Student("Alice");
        System.out.println(s2.studentCount);
        System.out.println("-----------------------------");
        System.out.println(Student.studentCount);
    }
}
