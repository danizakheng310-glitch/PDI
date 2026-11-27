import java.util.ArrayList;

class Student {
    private int sid;
    private String name;
    private int age;
    private float score;

    public Student(int sid, String name, int age, float score) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void display() {
        System.out.printf("%-10d %-15s %-10d %-10.1f%n", sid, name, age, score);
    }
}

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "Chunseang", 18, 80f));
        students.add(new Student(102, "Watana", 19, 81.5f));
        students.add(new Student(103, "Leap", 20, 90.2f));
        students.add(new Student(104, "Vuth", 21, 85.5f));

        System.out.println("Student Information");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s %-15s %-10s %-10s%n", "SID", "Name", "Age", "Score");
        System.out.println("-------------------------------------------------------");

        int i = 0;
        while (i < students.size()) {
            students.get(i).display();
            i++;
        }

        System.out.println("-------------------------------------------------------");
    }
}