# Lab 3: Code and Flowcharts

Flowcharts are written in Mermaid. They show as diagrams in GitHub, VS Code preview, and most Markdown viewers.

## Practice 1: Library Management System

### Flowchart

```mermaid
flowchart TD
    A([Start]) --> B[/"Input N (number of books)"/]
    B --> C["i = 0, total = 0"]
    C --> D{"i < N ?"}
    D -- Yes --> E[/"Input ID, Title, Author, Price"/]
    E --> F["Create Book, add to list<br/>total = total + price"]
    F --> G["i = i + 1"]
    G --> D
    D -- No --> H["Display all books"]
    H --> I["average = total / N"]
    I --> J[/"Print average price"/]
    J --> K([End])
```

### Code

**Book.java**

```java
package lab3;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;

    public Book() {
        this.id = 0;
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0;
    }

    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void print() {
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author + " | Price: $" + price);
    }
}
```

**BookTest.java**

```java
package lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BookTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = Integer.parseInt(sc.nextLine());

        List<Book> books = new ArrayList<Book>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Book " + (i + 1));
            System.out.print("  Book ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("  Title: ");
            String title = sc.nextLine();
            System.out.print("  Author: ");
            String author = sc.nextLine();
            System.out.print("  Price: ");
            double price = Double.parseDouble(sc.nextLine());

            Book b = new Book(id, title, author, price);
            books.add(b);
            total += b.getPrice();
        }

        System.out.println("\n--- All Books ---");
        for (Book b : books) {
            b.print();
        }
        System.out.println("Average price: $" + (total / books.size()));

        sc.close();
    }
}
```

## Practice 2: Temperature Conversion

### Flowchart

```mermaid
flowchart TD
    A([Start]) --> B[/"Input N (number of cities)"/]
    B --> C["i = 0"]
    C --> D{"i < N ?"}
    D -- Yes --> E[/"Input city name, Celsius"/]
    E --> F["Create City, add to list"]
    F --> G["i = i + 1"]
    G --> D
    D -- No --> H["i = 0"]
    H --> I{"i < N ?"}
    I -- Yes --> J["F = C x 9/5 + 32"]
    J --> K[/"Print city, C, F"/]
    K --> L["i = i + 1"]
    L --> I
    I -- No --> M([End])
```

### Code

**City.java**

```java
package lab3;

public class City {
    private String name;
    private double celsius;

    public City() {
        this.name = "Unknown";
        this.celsius = 0;
    }

    public City(String name, double celsius) {
        this.name = name;
        this.celsius = celsius;
    }

    public double toFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }

    public void print() {
        System.out.println(name + ": " + celsius + " C = " + toFahrenheit() + " F");
    }
}
```

**CityTest.java**

```java
package lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CityTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int n = Integer.parseInt(sc.nextLine());

        List<City> cities = new ArrayList<City>();

        for (int i = 0; i < n; i++) {
            System.out.print("City " + (i + 1) + " name: ");
            String name = sc.nextLine();
            System.out.print("Temperature in Celsius: ");
            double c = Double.parseDouble(sc.nextLine());
            cities.add(new City(name, c));
        }

        System.out.println("\n--- Temperatures ---");
        for (City c : cities) {
            c.print();
        }

        sc.close();
    }
}
```

## Practice 3: Employee Salary Management

### Flowchart

```mermaid
flowchart TD
    A([Start]) --> B[/"Input N (number of employees)"/]
    B --> C["i = 0"]
    C --> D{"i < N ?"}
    D -- Yes --> E[/"Input ID, Name, Basic Salary"/]
    E --> F["Create Employee, add to list"]
    F --> G["i = i + 1"]
    G --> D
    D -- No --> H["i = 0"]
    H --> I{"i < N ?"}
    I -- Yes --> J["HRA = 20% of Basic<br/>TCA = 10% of Basic<br/>Gross = Basic + HRA + TCA"]
    J --> K[/"Print all details and Gross"/]
    K --> L["i = i + 1"]
    L --> I
    I -- No --> M([End])
```

### Code

**Employee.java**

```java
package lab3;

public class Employee {
    private int id;
    private String name;
    private double basicSalary;

    public Employee() {
        this.id = 0;
        this.name = "Unknown";
        this.basicSalary = 0;
    }

    public Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public double getHRA() {
        return basicSalary * 0.20;
    }

    public double getTCA() {
        return basicSalary * 0.10;
    }

    public double getGrossSalary() {
        return basicSalary + getHRA() + getTCA();
    }

    public void print() {
        System.out.println("ID: " + id + " | Name: " + name + " | Basic: " + basicSalary
                + " | HRA: " + getHRA() + " | TCA: " + getTCA() + " | Gross: " + getGrossSalary());
    }
}
```

**EmployeeTest.java**

```java
package lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = Integer.parseInt(sc.nextLine());

        List<Employee> employees = new ArrayList<Employee>();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee " + (i + 1));
            System.out.print("  Employee ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("  Name: ");
            String name = sc.nextLine();
            System.out.print("  Basic salary: ");
            double basic = Double.parseDouble(sc.nextLine());
            employees.add(new Employee(id, name, basic));
        }

        System.out.println("\n--- Salary Details ---");
        for (Employee e : employees) {
            e.print();
        }

        sc.close();
    }
}
```

## Practice 4: Student Grades Calculation

### Flowchart

```mermaid
flowchart TD
    A([Start]) --> B[/"Input N (number of students)"/]
    B --> C["i = 0"]
    C --> D{"i < N ?"}
    D -- Yes --> E[/"Input ID, Name"/]
    E --> F[/"Input 5 marks"/]
    F --> G["Create StudentGrade, add to list"]
    G --> H["i = i + 1"]
    H --> D
    D -- No --> I["i = 0"]
    I --> J{"i < N ?"}
    J -- Yes --> K["total = sum of 5 marks<br/>average = total / 5"]
    K --> L{"average >= 90 ?"}
    L -- Yes --> L1["Grade = A"]
    L -- No --> M{"average >= 75 ?"}
    M -- Yes --> M1["Grade = B"]
    M -- No --> N{"average >= 50 ?"}
    N -- Yes --> N1["Grade = C"]
    N -- No --> N2["Grade = F"]
    L1 --> O[/"Print details, total, average, grade"/]
    M1 --> O
    N1 --> O
    N2 --> O
    O --> P["i = i + 1"]
    P --> J
    J -- No --> Q([End])
```

### Code

**StudentGrade.java**

```java
package lab3;

public class StudentGrade {
    private int id;
    private String name;
    private double[] marks;

    public StudentGrade() {
        this.id = 0;
        this.name = "Unknown";
        this.marks = new double[5];
    }

    public StudentGrade(int id, String name, double[] marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public double getTotal() {
        double total = 0;
        for (double m : marks) {
            total += m;
        }
        return total;
    }

    public double getAverage() {
        return getTotal() / 5;
    }

    public char getGrade() {
        double avg = getAverage();
        if (avg >= 90) {
            return 'A';
        } else if (avg >= 75) {
            return 'B';
        } else if (avg >= 50) {
            return 'C';
        } else {
            return 'F';
        }
    }

    public void print() {
        System.out.println("ID: " + id + " | Name: " + name + " | Total: " + getTotal()
                + " | Average: " + getAverage() + " | Grade: " + getGrade());
    }
}
```

**StudentGradeTest.java**

```java
package lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class StudentGradeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(sc.nextLine());

        List<StudentGrade> students = new ArrayList<StudentGrade>();

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1));
            System.out.print("  Student ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("  Name: ");
            String name = sc.nextLine();

            double[] marks = new double[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("  Mark " + (j + 1) + ": ");
                marks[j] = Double.parseDouble(sc.nextLine());
            }
            students.add(new StudentGrade(id, name, marks));
        }

        System.out.println("\n--- Student Results ---");
        for (StudentGrade s : students) {
            s.print();
        }

        sc.close();
    }
}
```

## Practice 5: Simple Banking System

### Flowchart

```mermaid
flowchart TD
    A([Start]) --> B[/"Input N (number of customers)"/]
    B --> C["i = 0"]
    C --> D{"i < N ?"}
    D -- Yes --> E[/"Input account number, Name, Balance"/]
    E --> F{"Account number<br/>is 14 digits?"}
    F -- No --> E
    F -- Yes --> G["Create Account, add to list<br/>i = i + 1"]
    G --> D
    D -- No --> H[/"Show menu, input choice"/]
    H --> I{"choice ?"}
    I -- "1 Deposit" --> J[/"Input account number, amount"/]
    I -- "2 Withdraw" --> K[/"Input account number, amount"/]
    I -- "3 Show all" --> L[/"Print all accounts"/]
    I -- "0 Exit" --> Z([End])
    J --> J1{"Account found?"}
    J1 -- No --> J2[/"Print: Account not found"/]
    J1 -- Yes --> J3["balance = balance + amount"]
    J3 --> J4[/"Print updated account"/]
    K --> K1{"Account found?"}
    K1 -- No --> J2
    K1 -- Yes --> K2{"amount <= balance ?"}
    K2 -- No --> K3[/"Print: Insufficient balance"/]
    K2 -- Yes --> K4["balance = balance - amount"]
    K4 --> J4
    J2 --> H
    J4 --> H
    K3 --> H
    L --> H
```

### Code

**Account.java**

```java
package lab3;

public class Account {
    private String accountNumber;
    private String name;
    private double balance;

    public Account() {
        this.accountNumber = "00000000000000";
        this.name = "Unknown";
        this.balance = 0;
    }

    public Account(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdraw successful.");
        }
    }

    public void print() {
        System.out.println("Account: " + accountNumber + " | Name: " + name + " | Balance: $" + balance);
    }
}
```

**AccountTest.java**

```java
package lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AccountTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = Integer.parseInt(sc.nextLine());

        List<Account> accounts = new ArrayList<Account>();

        for (int i = 0; i < n; i++) {
            System.out.println("Customer " + (i + 1));
            String number;
            do {
                System.out.print("  Account number (14 digits): ");
                number = sc.nextLine();
            } while (number.length() != 14);
            System.out.print("  Name: ");
            String name = sc.nextLine();
            System.out.print("  Balance: ");
            double balance = Double.parseDouble(sc.nextLine());
            accounts.add(new Account(number, name, balance));
        }

        int choice;
        do {
            System.out.println("\n1. Deposit  2. Withdraw  3. Show all  0. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            if (choice == 1 || choice == 2) {
                System.out.print("Account number: ");
                String number = sc.nextLine();

                Account found = null;
                for (Account a : accounts) {
                    if (a.getAccountNumber().equals(number)) {
                        found = a;
                    }
                }

                if (found == null) {
                    System.out.println("Account not found.");
                } else {
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(sc.nextLine());
                    if (choice == 1) {
                        found.deposit(amount);
                    } else {
                        found.withdraw(amount);
                    }
                    found.print();
                }
            } else if (choice == 3) {
                for (Account a : accounts) {
                    a.print();
                }
            }
        } while (choice != 0);

        sc.close();
    }
}
```

