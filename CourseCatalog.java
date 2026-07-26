import java.util.ArrayList;
import java.util.List;

public class CourseCatalog {
    private List<CatalogCourse> courses;

    public CourseCatalog() {
        courses = new ArrayList<>();

        CatalogCourse cs101 = new CatalogCourse(
                "CS101",
                "Introduction to Programming",
                "Computer Science",
                3
        );

        CatalogCourse cs201 = new CatalogCourse(
                "CS201",
                "Programming II",
                "Computer Science",
                3
        );
        cs201.addPrerequisite("CS101");

        CatalogCourse cs310 = new CatalogCourse(
                "CS310",
                "Software Engineering",
                "Computer Science",
                3
        );
        cs310.addPrerequisite("CS201");

        CatalogCourse cs420 = new CatalogCourse(
                "CS420",
                "Artificial Intelligence",
                "Computer Science",
                3
        );
        cs420.addPrerequisite("CS201");

        courses.add(cs101);
        courses.add(cs201);
        courses.add(cs310);
        courses.add(cs420);
    }

    public CatalogCourse findCourseByCode(String courseCode) {
        for (CatalogCourse course : courses) {
            if (course.getCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }

        return null;
    }

    public List<CatalogCourse> getCourses() {
        return courses;
    }
}
