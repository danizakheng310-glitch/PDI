public class Student {
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