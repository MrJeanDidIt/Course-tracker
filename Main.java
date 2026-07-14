import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Course Tracker!");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Placeholder major data - Person 2 will replace with real catalog-backed version
        Major major = new Major("Computer Science", List.of("CS101", "CS201"), List.of("CS310", "CS420"));
        Student student = new Student(name, major, 4);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add completed course");
            System.out.println("2. View GPA");
            System.out.println("3. Get course recommendations");
            System.out.println("4. View all completed courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number 1-5.");
                continue;
            }

            switch (choice) {
                case 1:
                    addCourse(sc, student);
                    break;
                case 2:
                    System.out.printf("Current GPA: %.2f%n", GPACalculator.calculateGPA(student));
                    break;
                case 3:
                    System.out.println("Recommended courses:");
                    for (String rec : CourseRecommender.recommend(student)) {
                        System.out.println("- " + rec);
                    }
                    break;
                case 4:
                    if (student.getCompletedCourses().isEmpty()) {
                        System.out.println("No courses added yet.");
                    } else {
                        for (Course c : student.getCompletedCourses()) {
                            System.out.println("- " + c);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
        sc.close();
    }

    private static void addCourse(Scanner sc, Student student) {
        System.out.print("Course name: ");
        String name = sc.nextLine();
        System.out.print("Subject (e.g. Math, Physics): ");
        String subject = sc.nextLine();

        System.out.print("Credits: ");
        int credits;
        try {
            credits = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Credits must be a number.");
            return;
        }
        if (!InputValidator.isValidCredits(credits)) {
            System.out.println("Credits must be greater than 0.");
            return;
        }

        System.out.print("Grade (A-F): ");
        String grade = sc.nextLine().trim().toUpperCase();
        if (!InputValidator.isValidGrade(grade)) {
            System.out.println("Grade must be A, B, C, D, or F.");
            return;
        }

        student.addCourse(new Course(name, subject, credits, grade));
        System.out.println("Course added!");
    }
}
