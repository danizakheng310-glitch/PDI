import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Ex7 {
    static ArrayList<String[]> data = new ArrayList<>();

    static String findFile() {
        String name = "CandidatePerformanceTest.csv";
        String home = System.getProperty("user.home");
        String[] places = {
            name,
            home + "/Downloads/" + name,
            home + "/Documents/" + name,
            home + "/Desktop/" + name
        };
        for (String p : places) {
            if (new File(p).exists()) {
                return p;
            }
        }
        return name;
    }

    public static void main(String[] args) throws IOException {
        File source = new File(findFile());
        if (!source.exists()) {
            System.out.println("File not found. Copy CandidatePerformanceTest.csv into: " + new File(".").getAbsolutePath());
            return;
        }
        System.out.println("Reading from: " + source.getAbsolutePath());

        for (String line : Files.readAllLines(source.toPath())) {
            String[] p = line.replace("\"", "").split(",");
            if (p.length >= 7) {
                String g = p[1].trim().toLowerCase();
                if (g.equals("male") || g.equals("female")) {
                    data.add(p);
                }
            }
        }

        TreeMap<String, ArrayList<String[]>> groups = new TreeMap<>();
        for (String[] p : data) {
            groups.computeIfAbsent(p[2].trim(), k -> new ArrayList<>()).add(p);
        }

        for (String g : groups.keySet()) {
            ArrayList<String[]> list = groups.get(g);
            int male = 0;
            for (String[] p : list) {
                if (p[1].trim().equalsIgnoreCase("male")) male++;
            }
            int female = list.size() - male;
            double malePct = male * 100.0 / list.size();
            double femalePct = female * 100.0 / list.size();

            System.out.println(g + ": " + list.size());
            System.out.printf("Male: %.2f%%%n", malePct);
            System.out.printf("Female: %.2f%%%n", femalePct);

            String fileName = g.replace(" ", "") + ".csv";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (String[] p : list) {
                    writer.write(String.join(",", p));
                    writer.newLine();
                }
                writer.write("Total students," + list.size());
                writer.newLine();
                writer.write(String.format("Male %%,%.2f", malePct));
                writer.newLine();
                writer.write(String.format("Female %%,%.2f", femalePct));
                writer.newLine();
                System.out.println("Saved at: " + new File(fileName).getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}