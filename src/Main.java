import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("UNIVERSITY SYSTEM WITH INPUT");
        System.out.println("=================================");

        // create department with user input
        System.out.println("\n---CREATE DEPARTMENT---");
        System.out.print("enter department name: ");
        String deptName = scanner.nextLine();

        Department csDept = new Department(deptName);
        System.out.println("Created " + csDept.getDepartmentName() + " Department\n");

        // add courses with user input
        System.out.println("---ADD COURSES---");

        try {
            System.out.print("how many courses do you want to add? ");
            int numCourses = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= numCourses; i++) {
                System.out.println("\nenter details for Course " + i + ":");

                System.out.print("course Code (e.g., CS101): ");
                String code = scanner.nextLine();

                System.out.print("course Name: ");
                String name = scanner.nextLine();

                System.out.print("credit Units: ");
                int credits = scanner.nextInt();
                scanner.nextLine();

                Course course = new Course(code, name, credits);
                csDept.addCourse(course);

                System.out.println("course added successfully!");
            }
        } catch (InputMismatchException e) {
            System.out.println("error: Please enter a valid number!");
            scanner.nextLine();
        }

        // add lecturers with user input
        System.out.println("\n---ADD LECTURERS---");

        try {
            System.out.print("how many lecturers do you want to add? ");
            int numLecturers = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= numLecturers; i++) {
                System.out.println("\nenter details for Lecturer " + i + ":");

                System.out.print("lecturer ID: ");
                String id = scanner.nextLine();

                System.out.print("name: ");
                String name = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                System.out.print("salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Subject they teach: ");
                String subject = scanner.nextLine();

                Lecturer lecturer = new Lecturer(id, name, email, salary, subject);
                csDept.addLecturer(lecturer);

                System.out.println("lecturer added successfully!");
            }
        } catch (InputMismatchException e) {
            System.out.println("error: Please enter a valid number for salary!");
            scanner.nextLine();
        }

        // add students with user inputs
        System.out.println("\n---ADD STUDENTS---");

        try {
            System.out.print("how many students do you want to add? ");
            int numStudents = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= numStudents; i++) {
                System.out.println("\nenter details for Student " + i + ":");

                System.out.print("student ID: ");
                String id = scanner.nextLine();

                System.out.print("name: ");
                String name = scanner.nextLine();

                System.out.print("email: ");
                String email = scanner.nextLine();

                System.out.print("course: ");
                String course = scanner.nextLine();

                System.out.print("Year (1-4): ");
                int year = scanner.nextInt();
                scanner.nextLine();

                if (year < 1 || year > 4) {
                    throw new IllegalArgumentException("year must be between 1 and 4");
                }

                Student student = new Student(id, name, email, course, year);
                csDept.addStudent(student);

                System.out.println("student added successfully!");
            }
        } catch (InputMismatchException e) {
            System.out.println("error: Please enter a valid number for year!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getMessage());
        }

        // assign lecturers to courses
        System.out.println("\n---ASSIGN LECTURERS TO COURSES---");

        try {
            // show available courses
            System.out.println("\navailable Courses:");
            for (int i = 0; i < csDept.getCourses().size(); i++) {
                System.out.println((i+1) + ". " + csDept.getCourses().get(i).getCourseName());
            }

            // Show available lecturers
            System.out.println("\navailable Lecturers:");
            for (int i = 0; i < csDept.getLecturers().size(); i++) {
                System.out.println((i+1) + ". " + csDept.getLecturers().get(i).getName());
            }

            System.out.print("\nhow many assignments do you want to make? ");
            int numAssignments = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= numAssignments; i++) {
                System.out.println("\nAssignment " + i + ":");

                try {
                    System.out.print("enter course number: ");
                    int courseNum = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("enter lecturer number: ");
                    int lecturerNum = scanner.nextInt();
                    scanner.nextLine();

                    Course selectedCourse = csDept.getCourses().get(courseNum - 1);
                    Lecturer selectedLecturer = csDept.getLecturers().get(lecturerNum - 1);

                    selectedCourse.setLecturer(selectedLecturer);
                    System.out.println("assigned " + selectedLecturer.getName() + " to teach " + selectedCourse.getCourseName());

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("error: Invalid course or lecturer number! try again.");
                } catch (InputMismatchException e) {
                    System.out.println("error: Please enter numbers only!");
                    scanner.nextLine();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("error: Please enter a valid number for assignments!");
            scanner.nextLine();
        }

        // display final information
        System.out.println("\n=================================");
        System.out.println("FINAL DEPARTMENT SUMMARY");
        System.out.println("=================================");

        // Department info
        System.out.println("\n---DEPARTMENT INFO---");
        System.out.println("department: " + csDept.getDepartmentName());
        System.out.println("total Courses: " + csDept.getCourses().size());
        System.out.println("total Lecturers: " + csDept.getLecturers().size());
        System.out.println("total Students: " + csDept.getStudents().size());

        // List all courses
        System.out.println("\n---COURSES---");
        if (csDept.getCourses().isEmpty()) {
            System.out.println("no courses added.");
        } else {
            for (int i = 0; i < csDept.getCourses().size(); i++) {
                Course c = csDept.getCourses().get(i);
                String lecturerName = (c.getLecturer() != null) ? c.getLecturer().getName() : "Not assigned";
                System.out.println((i+1) + ". " + c.getCourseCode() + " - " + c.getCourseName() +
                        " (" + c.getCreditUnits() + " credits) - Lecturer: " + lecturerName);
            }
        }

        // List all lecturers
        System.out.println("\n---LECTURERS---");
        if (csDept.getLecturers().isEmpty()) {
            System.out.println("no lecturers added.");
        } else {
            for (int i = 0; i < csDept.getLecturers().size(); i++) {
                Lecturer l = csDept.getLecturers().get(i);
                System.out.println((i+1) + ". " + l.getName() + " - " + l.getSubject() +
                        " - Salary: UGX " + l.calculatePay());
            }
        }

        // list all students
        System.out.println("\n---STUDENTS---");
        if (csDept.getStudents().isEmpty()) {
            System.out.println("No students added.");
        } else {
            for (int i = 0; i < csDept.getStudents().size(); i++) {
                Student s = csDept.getStudents().get(i);
                System.out.println((i+1) + ". " + s.getName() + " (ID: " + s.getId() + ") - " +
                        s.getCourse() + " - Year " + s.getYear());
            }
        }

        // payroll calculation
        System.out.println("\n---PAYROLL---");
        try {
            double totalSalary = 0;
            if (csDept.getLecturers().isEmpty()) {
                System.out.println("no lecturers to calculate payroll.");
            } else {
                for (Lecturer l : csDept.getLecturers()) {
                    totalSalary += l.calculatePay();
                }
                System.out.println("total monthly payroll: UGX " + totalSalary);
            }
        } catch (Exception e) {
            System.out.println("error calculating payroll: " + e.getMessage());
        } finally {
            System.out.println("payroll calculation attempted.");
        }

        // demonstrate teaching
        System.out.println("\n---TEACHING SESSION---");
        try {
            if (csDept.getLecturers().isEmpty()) {
                System.out.println("no lecturers to teach.");
            } else {
                for (Lecturer l : csDept.getLecturers()) {
                    if (l.getSubject() != null && !l.getSubject().isEmpty()) {
                        l.teach();
                    } else {
                        System.out.println(l.getName() + " has no subject assigned.");
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("error: Some lecturer data is missing.");
        }

        System.out.println("\n=================================");
        System.out.println("PROGRAM COMPLETED SUCCESSFULLY!");
        System.out.println("=================================");

        scanner.close();
    }
}