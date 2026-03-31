import java.io.*;
import java.util.*;

public class FileHandler {


    public static void saveData(Department dept, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {


            writer.write("DEPARTMENT:" + dept.getDepartmentName());
            writer.newLine();


            writer.write("COURSES:" + dept.getCourses().size());
            writer.newLine();
            for (Course c : dept.getCourses()) {
                String lecturerName = (c.getLecturer() != null) ? c.getLecturer().getName() : "none";
                writer.write(c.getCourseCode() + "," + c.getCourseName() + "," +
                        c.getCreditUnits() + "," + lecturerName);
                writer.newLine();
            }


            writer.write("LECTURERS:" + dept.getLecturers().size());
            writer.newLine();
            for (Lecturer l : dept.getLecturers()) {
                writer.write(l.getId() + "," + l.getName() + "," + l.getEmail() + "," +
                        l.getSalary() + "," + l.getSubject());
                writer.newLine();
            }


            writer.write("STUDENTS:" + dept.getStudents().size());
            writer.newLine();
            for (Student s : dept.getStudents()) {
                writer.write(s.getId() + "," + s.getName() + "," + s.getEmail() + "," +
                        s.getCourse() + "," + s.getYear());
                writer.newLine();
            }

            System.out.println("data saved successfully to " + filename);

        } catch (IOException e) {
            System.out.println("error saving data: " + e.getMessage());
        }
    }


    public static Department loadData(String filename) {
        Department dept = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            List<Course> courses = new ArrayList<>();
            List<Lecturer> lecturers = new ArrayList<>();
            List<Student> students = new ArrayList<>();
            String deptName = "";

            while ((line = reader.readLine()) != null) {

                if (line.startsWith("DEPARTMENT:")) {
                    deptName = line.substring(11);

                } else if (line.startsWith("COURSES:")) {
                    int numCourses = Integer.parseInt(line.substring(8));
                    for (int i = 0; i < numCourses; i++) {
                        String courseLine = reader.readLine();
                        if (courseLine != null) {
                            String[] parts = courseLine.split(",");
                            Course c = new Course(parts[0], parts[1], Integer.parseInt(parts[2]));
                            courses.add(c);
                        }
                    }

                } else if (line.startsWith("LECTURERS:")) {
                    int numLecturers = Integer.parseInt(line.substring(10));
                    for (int i = 0; i < numLecturers; i++) {
                        String lecturerLine = reader.readLine();
                        if (lecturerLine != null) {
                            String[] parts = lecturerLine.split(",");
                            Lecturer l = new Lecturer(parts[0], parts[1], parts[2],
                                    Double.parseDouble(parts[3]), parts[4]);
                            lecturers.add(l);
                        }
                    }

                } else if (line.startsWith("STUDENTS:")) {
                    int numStudents = Integer.parseInt(line.substring(9));
                    for (int i = 0; i < numStudents; i++) {
                        String studentLine = reader.readLine();
                        if (studentLine != null) {
                            String[] parts = studentLine.split(",");
                            Student s = new Student(parts[0], parts[1], parts[2],
                                    parts[3], Integer.parseInt(parts[4]));
                            students.add(s);
                        }
                    }
                }
            }


            dept = new Department(deptName);
            dept.setCourses(courses);
            dept.setLecturers(lecturers);
            dept.setStudents(students);


            for (Course c : courses) {
                for (Lecturer l : lecturers) {
                    // simple matching - you can improve this
                    if (c.getCourseName().contains(l.getSubject())) {
                        c.setLecturer(l);
                        break;
                    }
                }
            }

            System.out.println("data loaded successfully from " + filename);

        } catch (FileNotFoundException e) {
            System.out.println("no saved file found. starting fresh.");
            return null;
        } catch (IOException e) {
            System.out.println("error loading data: " + e.getMessage());
            return null;
        } catch (NumberFormatException e) {
            System.out.println("error reading number from file: " + e.getMessage());
            return null;
        }

        return dept;
    }

    // check if save file exists
    public static boolean saveFileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }
}