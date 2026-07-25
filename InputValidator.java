import java.util.Scanner; 

/**
 * Handles input parsing, range validation, and crash-proof data entry
 * for the Panther Planner application.
 * 
 * @author Pablo Lucero (Input & Validation Programmer)
 */
public class InputValidator {

    /**
     * Validates whether a letter grade is a valid letter grade (A, B, C, D, F).
     *
     * @param grade The grade string to check.
     * @return true if valid; false otherwise.
     */
    public static boolean isValidGrade(String grade) {
        if (grade == null) {
            return false;
        }
        return grade.trim().toUpperCase().matches("[A-DF]");
    }

    /**
     * Enforces logic bounds on numeric credits (0 to 5 credits per course).
     *
     * @param credits The credit value to check.
     * @return true if between 0 and 5 inclusive; false otherwise.
     */
    public static boolean isValidCredits(int credits) {
        return credits >= 0 && credits <= 5;
    }

    /**
     * Checks if the graduation timeframe is valid.
     *
     * @param years The target years for graduation.
     * @return true if 2 or more years; false otherwise.
     */
    public static boolean isValidTimeframe(int years) {
        return years >= 2;
    }

    /**
     * Validates that a given text input is not empty or purely whitespace.
     *
     * @param input The raw input string.
     * @return true if string contains non-whitespace characters; false otherwise.
     */
    public static boolean isValidText(String input) {
        return input != null && !input.trim().isEmpty();
    }

    /**
     * Safely prompts the user for a valid integer within a given menu option range.
     * Intercepts non-numeric inputs without crashing.
     *
     * @param sc Scanner object for console input.
     * @param min Minimum acceptable integer.
     * @param max Maximum acceptable integer.
     * @return A valid integer selected by the user.
     */
    public static int readIntInRange(Scanner sc, int min, int max) {
        while (true) {
            String rawInput = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(rawInput);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Error: Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.printf("Error: '%s' is not a valid number. Please try again: ", rawInput);
            }
        }
    }

    /**
     * Prompts until the user provides a valid, non-empty string.
     *
     * @param sc Scanner object for console input.
     * @param prompt The prompt string to display to the user.
     * @return A non-empty string provided by the user.
     */
    public static String readNonEmptyString(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (true) {
            String input = sc.nextLine();
            if (isValidText(input)) {
                return input.trim();
            }
            System.out.print("Error: Input cannot be empty. Try again: ");
        }
    }
}
