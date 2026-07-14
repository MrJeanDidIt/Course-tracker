import java.util.List;

public class Major {
    private String name;
    private List<String> requiredCourses;
    private List<String> electiveOptions;

    public Major(String name, List<String> requiredCourses, List<String> electiveOptions) {
        this.name = name;
        this.requiredCourses = requiredCourses;
        this.electiveOptions = electiveOptions;
    }

    public String getName() { return name; }
    public List<String> getRequiredCourses() { return requiredCourses; }
    public List<String> getElectiveOptions() { return electiveOptions; }
}
