import java.util.ArrayList;
import java.util.List;

public class CatalogCourse {
    private String code;
    private String name;
    private String subject;
    private int credits;
    private List<String> prerequisites;

    public CatalogCourse(String code, String name,
                         String subject, int credits) {

        this.code = code;
        this.name = name;
        this.subject = subject;
        this.credits = credits;
        prerequisites = new ArrayList<>();
    }

    public void addPrerequisite(String courseCode) {
        prerequisites.add(courseCode);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getCredits() {
        return credits;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }
}
