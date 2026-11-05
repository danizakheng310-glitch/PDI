import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Ex6 {
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

        question1();
        question2();
        question3();
        question4();
    }

    static double pct(int part, int whole) {
        return whole == 0 ? 0 : part * 100.0 / whole;
    }

    static int countMale(List<String[]> list) {
        int c = 0;
        for (String[] p : list) {
            if (p[1].trim().equalsIgnoreCase("male")) c++;
        }
        return c;
    }

    static double average(String[] p) {
        return (Double.parseDouble(p[5].trim()) + Double.parseDouble(p[6].trim()) + Double.parseDouble(p[7].trim())) / 3;
    }

    static void printStats(String label, List<String[]> list) {
        int male = countMale(list);
        int female = list.size() - male;
        System.out.println(label + ": " + list.size());
        System.out.printf("Male: %.2f%%%n", pct(male, list.size()));
        System.out.printf("Female: %.2f%%%n", pct(female, list.size()));
    }

    static void question1() {
        System.out.println("--- Q1 ---");
        printStats("Total candidates", data);
    }

    static void question2() {
        System.out.println("--- Q2 ---");
        ArrayList<String[]> result = new ArrayList<>();
        for (String[] p : data) {
            if (average(p) >= 90) result.add(p);
        }
        printStats("Average at least 90", result);
    }

    static void question3() {
        System.out.println("--- Q3 ---");
        int math = 0, english = 0, computer = 0, all = 0;
        for (String[] p : data) {
            boolean m = Double.parseDouble(p[5].trim()) >= 85;
            boolean e = Double.parseDouble(p[6].trim()) >= 85;
            boolean c = Double.parseDouble(p[7].trim()) >= 85;
            if (m) math++;
            if (e) english++;
            if (c) computer++;
            if (m && e && c) all++;
        }
        System.out.println("Math at least 85: " + math);
        System.out.println("English at least 85: " + english);
        System.out.println("Computer at least 85: " + computer);
        System.out.println("All three at least 85: " + all);
    }

    static void question4() {
        System.out.println("--- Q4 ---");
        TreeMap<String, ArrayList<String[]>> groups = new TreeMap<>();
        for (String[] p : data) {
            groups.computeIfAbsent(p[2].trim(), k -> new ArrayList<>()).add(p);
        }
        for (String g : groups.keySet()) {
            printStats(g, groups.get(g));
        }
    }
}