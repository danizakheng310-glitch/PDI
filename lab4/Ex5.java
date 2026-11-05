import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String[]> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Ex3StudentData.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 3; i++) {
            System.out.println("New student " + i);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Gender: ");
            String gender = sc.nextLine();
            students.add(new String[]{name, id, gender});
        }

        students.sort((a, b) -> a[0].compareToIgnoreCase(b[0]));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ex3StudentData.csv"))) {
            for (String[] s : students) {
                writer.write(s[0] + "," + s[1] + "," + s[2]);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] s : students) {
            System.out.println(s[0] + "," + s[1] + "," + s[2]);
        }
    }
}
