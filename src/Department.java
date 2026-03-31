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

    // getters
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

    // setters for loading from file
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // add methods
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("added course: " + course.getCourseName());
    }

    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
        System.out.println("added lecturer: " + lecturer.getName());
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("added student: " + student.getName());
    }

    public void displayInfo() {
        System.out.println("\n=== " + departmentName + " DEPARTMENT ===");
        System.out.println("courses: " + courses.size());
        System.out.println("lecturers: " + lecturers.size());
        System.out.println("students: " + students.size());
    }
}