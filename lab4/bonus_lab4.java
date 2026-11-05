import java.io.*;
import java.util.ArrayList;

public class Bonus {
    static class Person implements Serializable {
        String name;
        String id;
        String gender;

        Person(String name, String id, String gender) {
            this.name = name;
            this.id = id;
            this.gender = gender;
        }

        String toCsv() {
            return name + "," + id + "," + gender;
        }

        static Person fromCsv(String line) {
            String[] p = line.split(",");
            return new Person(p[0].trim(), p[1].trim(), p[2].trim());
        }

        public String toString() {
            return name + " | " + id + " | " + gender;
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> team = new ArrayList<>();
        team.add(new Person("Daniza", "P20250018", "Male"));
        team.add(new Person("visal", "P20250019", "Female"));
        team.add(new Person("chorvon", "P20250020", "Male"));

        File csvFile = new File("team.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            for (Person p : team) {
                writer.write(p.toCsv());
                writer.newLine();
            }
            System.out.println("CSV saved at: " + csvFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Person> fromCsv = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fromCsv.add(Person.fromCsv(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Read back from CSV:");
        for (Person p : fromCsv) {
            System.out.println(p);
        }

        File serFile = new File("person.ser");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(serFile))) {
            out.writeObject(team);
            System.out.println("Serialized file saved at: " + serFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(serFile))) {
            @SuppressWarnings("unchecked")
            ArrayList<Person> fromSer = (ArrayList<Person>) in.readObject();
            System.out.println("Read back from person.ser:");
            for (Person p : fromSer) {
                System.out.println(p);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}