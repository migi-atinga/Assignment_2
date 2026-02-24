public class Student extends Person {
    private String course;
    private int year;

    public Student(String id, String name, String email, String course, int year) {
        super(id, name, email);
        this.course = course;
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
