import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private Major major;
    private List<Course> completedCourses;
    private int targetGraduationYears;

    public Student(String name, Major major, int targetGraduationYears) {
        this.name = name;
        this.major = major;
        this.targetGraduationYears = targetGraduationYears;
        this.completedCourses = new ArrayList<>();
    }

    public void addCourse(Course c) {
        completedCourses.add(c);
    }

    public String getName() { return name; }
    public Major getMajor() { return major; }
    public List<Course> getCompletedCourses() { return completedCourses; }
    public int getTargetGraduationYears() { return targetGraduationYears; }
}
