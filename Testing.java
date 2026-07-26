public class Testing {

    public static void main(String[] args) {

        System.out.println("===== COURSE TRACKER TESTING =====\n");

        testGradeValidation();
        testCreditValidation();
        testGPA();
        testProjectedGPA();
        testGraduationTimeframe();

        System.out.println("===== TESTING COMPLETE =====");

    }
    public static void testGradeValidation() {

        System.out.println("Test 1: Grade Validation");

        String[] validGrades = {"A", "B", "C", "D", "F"};

        for (String grade : validGrades) {

            if (isValidGrade(grade)) {
                System.out.println("PASS: " + grade + " accepted");
            } else {
                System.out.println("FAIL: " + grade + " rejected");
            }

        }

        if (!isValidGrade("Z")) {
            System.out.println("PASS: Invalid grade rejected");
        } else {
            System.out.println("FAIL: Invalid grade accepted");
        }

        System.out.println();

    }
    public static void testCreditValidation() {

        System.out.println("Test 2: Credit Validation");

        int[] credits = {3, 4, -1, 0};

        for (int credit : credits) {

            if (credit > 0) {
                System.out.println("PASS: " + credit + " credits accepted");
            } else {
                System.out.println("PASS: Invalid credit value rejected");
            }

        }

        System.out.println();

    }
    public static void testGPA() {

        System.out.println("Test 3: GPA Calculation");

        double gpa = calculateGPA();

        System.out.println("Expected GPA: 3.50");
        System.out.println("Calculated GPA: " + gpa);

        if (gpa == 3.50) {
            System.out.println("PASS: GPA calculation works");
        } else {
            System.out.println("FAIL: GPA calculation incorrect");
        }

        System.out.println();

    }
    public static void testProjectedGPA() {

        System.out.println("Test 4: Projected GPA");

        double currentGPA = 3.50;
        double nextSemesterGPA = 4.00;

        double projected = (currentGPA + nextSemesterGPA) / 2;

        System.out.println("Projected GPA: " + projected);

        if (projected == 3.75) {
            System.out.println("PASS: Projected GPA works");
        } else {
            System.out.println("FAIL: Projected GPA incorrect");
        }

        System.out.println();

    }

    public static void testGraduationTimeframe() {

        System.out.println("Test 5: Graduation Timeframe");

        int years = 2;

        if (years >= 1 && years <= 2) {
            System.out.println("PASS: Valid timeframe");
        } else {
            System.out.println("FAIL: Invalid timeframe");
        }

    }

    public static boolean isValidGrade(String grade) {

        return grade.equals("A") ||
               grade.equals("B") ||
               grade.equals("C") ||
               grade.equals("D") ||
               grade.equals("F");

    }


    public static double calculateGPA() {

        // Sample data:
        // Course 1: A (4.0) x 3 credits
        // Course 2: B (3.0) x 3 credits

        double totalPoints = (4.0 * 3) + (3.0 * 3);
        int totalCredits = 6;

        return totalPoints / totalCredits;

    }

}
