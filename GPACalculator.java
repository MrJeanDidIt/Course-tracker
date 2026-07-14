import java.util.List;

public class GPACalculator {
    // TODO(Person 4): replace with real subject-area averages + next-semester projection

    public static double calculateGPA(Student student) {
        List<Course> courses = student.getCompletedCourses();
        if (courses.isEmpty()) return 0.0;

        double totalPoints = 0;
        int totalCredits = 0;
        for (Course c : courses) {
            totalPoints += gradeToPoints(c.getGrade()) * c.getCredits();
            totalCredits += c.getCredits();
        }
        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    private static double gradeToPoints(String grade) {
        switch (grade) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            default: return 0.0;
        }
    }
}
