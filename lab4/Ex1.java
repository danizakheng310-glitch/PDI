import java.io.*;
import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("LuckyNumber.csv"))) {
            for (int i = 0; i < 500; i++) {
                writer.write(String.valueOf(rand.nextInt(1000) + 1));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("LuckyNumber.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
