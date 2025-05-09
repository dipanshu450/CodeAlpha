import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        System.out.println("=== Student Grade Tracker ===");

        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Student> students = new ArrayList<>();

            System.out.print("Enter number of students: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // consume newline

            for (int i = 0; i < n; i++) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();

                System.out.print("Enter grade for " + name + ": ");
                double grade = scanner.nextDouble();
                scanner.nextLine(); // consume newline

                students.add(new Student(name, grade));
            }

            if (students.isEmpty()) {
                System.out.println("No student data entered.");
                return;
            }

            double total = 0, highest = students.get(0).grade, lowest = students.get(0).grade;
            String topStudent = students.get(0).name, lowStudent = students.get(0).name;

            for (Student s : students) {
                total += s.grade;
                if (s.grade > highest) {
                    highest = s.grade;
                    topStudent = s.name;
                }
                if (s.grade < lowest) {
                    lowest = s.grade;
                    lowStudent = s.name;
                }
            }

            double average = total / students.size();

            System.out.println("\n--- Grade Summary ---");
            System.out.printf("Average Grade: %.2f\n", average);
            System.out.println("Highest Grade: " + highest + " (by " + topStudent + ")");
            System.out.println("Lowest Grade: " + lowest + " (by " + lowStudent + ")");

            System.out.println("\nAll Student Grades:");
            for (Student s : students) {
                System.out.println(s.name + ": " + s.grade);
            }
        }
    }
}
