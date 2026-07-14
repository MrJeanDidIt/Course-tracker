public class Course {
    private String name;
    private String subject;
    private int credits;
    private String grade; // "A"-"F", empty string if not yet completed

    public Course(String name, String subject, int credits, String grade) {
        this.name = name;
        this.subject = subject;
        this.credits = credits;
        this.grade = grade;
    }

    public String getName() { return name; }
    public String getSubject() { return subject; }
    public int getCredits() { return credits; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return name + " (" + subject + ", " + credits + " credits, grade: " + grade + ")";
    }
}
