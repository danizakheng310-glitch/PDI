import java.io.*;
import java.util.ArrayList;

public class Ex4 {
    public static void main(String[] args) {
        ArrayList<String[]> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Ex3StudentData.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] s : students) {
            System.out.println("Name: " + s[0] + ", ID: " + s[1] + ", Gender: " + s[2]);
        }
    }
}
