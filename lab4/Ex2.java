import java.io.*;
import java.util.*;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        Random rand = new Random();

        File folder = new File("Ex2LuckyNumber");
        folder.mkdirs();

        for (int i = 1; i <= n; i++) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(folder, "file" + i + ".csv")))) {
                for (int j = 0; j < 10; j++) {
                    writer.write(String.valueOf(rand.nextInt(100) + 1));
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(folder, "file" + i + ".csv")))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    numbers.add(Integer.parseInt(line.trim()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Numbers: " + numbers);
        System.out.println("Max: " + Collections.max(numbers));
        System.out.println("Min: " + Collections.min(numbers));
    }
}
