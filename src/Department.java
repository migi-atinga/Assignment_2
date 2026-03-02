import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Course> courses;
    private List<Lecturer> lecturers;
    private List<Student> students;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
        this.lecturers = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // ADD THESE GETTER METHODS (if they're missing)
    public String getDepartmentName() {
        return departmentName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public List<Student> getStudents() {
        return students;
    }

    // Your existing methods
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Added course: " + course.getCourseName());
    }

    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
        System.out.println("Added lecturer: " + lecturer.getName());
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added student: " + student.getName());
    }

    public void displayInfo() {
        System.out.println("\n=== " + departmentName + " DEPARTMENT ===");
        System.out.println("Number of courses: " + courses.size());
        System.out.println("Number of lecturers: " + lecturers.size());
        System.out.println("Number of students: " + students.size());
    }
}