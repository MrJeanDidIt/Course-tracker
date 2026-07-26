import java.util.ArrayList;
import java.util.List;

public class CourseRecommender {

    public static List<String> recommend(Student student) {
        List<String> recommendations = new ArrayList<>();
        CourseCatalog catalog = new CourseCatalog();

        if (student == null || student.getMajor() == null) {
            recommendations.add("No major information is available.");
            return recommendations;
        }

        // Check required courses
        List<String> requiredCourses =
                student.getMajor().getRequiredCourses();

        for (String courseCode : requiredCourses) {
            CatalogCourse course =
                    catalog.findCourseByCode(courseCode);

            if (course != null
                    && !hasCompletedCourse(student, courseCode)
                    && hasPrerequisites(student, course)) {

                recommendations.add(
                        course.getCode() + " - "
                                + course.getName()
                                + " [Required]"
                );
            }
        }

        // Check elective courses
        List<String> electiveCourses =
                student.getMajor().getElectiveOptions();

        for (String courseCode : electiveCourses) {
            CatalogCourse course =
                    catalog.findCourseByCode(courseCode);

            if (course != null
                    && !hasCompletedCourse(student, courseCode)
                    && hasPrerequisites(student, course)) {

                recommendations.add(
                        course.getCode() + " - "
                                + course.getName()
                                + " [Elective]"
                );
            }
        }

        if (recommendations.isEmpty()) {
            recommendations.add(
                    "No courses are available to recommend."
            );
        }

        return recommendations;
    }

    private static boolean hasCompletedCourse(
            Student student, String courseCode) {

        for (Course completedCourse :
                student.getCompletedCourses()) {

            if (completedCourse.getName()
                    .equalsIgnoreCase(courseCode)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasPrerequisites(
            Student student, CatalogCourse course) {

        List<String> prerequisites =
                course.getPrerequisites();

        for (String prerequisite : prerequisites) {
            if (!hasCompletedCourse(student, prerequisite)) {
                return false;
            }
        }

        return true;
    }
}
