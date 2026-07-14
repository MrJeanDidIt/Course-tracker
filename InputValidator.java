public class InputValidator {
    // TODO(Person 3): flesh out real validation + user-facing error messages

    public static boolean isValidGrade(String grade) {
        return grade.matches("[A-F]");
    }

    public static boolean isValidCredits(int credits) {
        return credits > 0;
    }

    public static boolean isValidTimeframe(int years) {
        return years >= 2; // A.A. transfer minimum
    }
}
