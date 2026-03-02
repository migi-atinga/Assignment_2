public class Course {
    private String courseCode;
    private String courseName;
    private int creditUnits;
    private Lecturer lecturer;

    public Course(String courseCode, String courseName, int creditUnits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditUnits = creditUnits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditUnits() {
        return creditUnits;
    }

    public void setCreditUnits(int creditUnits) {
        this.creditUnits = creditUnits;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}