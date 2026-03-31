import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Department csDept = null;
        String saveFile = "university_data.txt";

        System.out.println("=================================");
        System.out.println("UNIVERSITY SYSTEM");
        System.out.println("=================================");

        // check for existing save file
        System.out.println("\n---LOAD SAVED DATA?---");
        System.out.print("do you want to load previous data? (yes/no): ");
        String loadChoice = scanner.nextLine();

        if (loadChoice.equalsIgnoreCase("yes") && FileHandler.saveFileExists(saveFile)) {
            csDept = FileHandler.loadData(saveFile);
            if (csDept != null) {
                System.out.println("loaded " + csDept.getDepartmentName() + " department");
                csDept.displayInfo();
            }
        }

        // if no data loaded create new department
        if (csDept == null) {
            System.out.println("\n---CREATE NEW DEPARTMENT---");
            System.out.print("enter department name: ");
            String deptName = scanner.nextLine();
            csDept = new Department(deptName);
            System.out.println("created " + csDept.getDepartmentName() + " department\n");

            // add courses
            addCourses(scanner, csDept);

            // add lecturers
            addLecturers(scanner, csDept);

            // add students
            addStudents(scanner, csDept);

            // assign lecturers to courses
            assignLecturersToCourses(scanner, csDept);
        }

        // show menu for further actions
        boolean running = true;
        while (running) {
            System.out.println("\n=================================");
            System.out.println("MAIN MENU");
            System.out.println("=================================");
            System.out.println("1. view all data");
            System.out.println("2. add more courses");
            System.out.println("3. add more lecturers");
            System.out.println("4. add more students");
            System.out.println("5. assign lecturers to courses");
            System.out.println("6. save and exit");
            System.out.println("7. exit without saving");
            System.out.print("\nchoose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        displayAllData(csDept);
                        break;
                    case 2:
                        addCourses(scanner, csDept);
                        break;
                    case 3:
                        addLecturers(scanner, csDept);
                        break;
                    case 4:
                        addStudents(scanner, csDept);
                        break;
                    case 5:
                        assignLecturersToCourses(scanner, csDept);
                        break;
                    case 6:
                        FileHandler.saveData(csDept, saveFile);
                        System.out.println("data saved. goodbye!");
                        running = false;
                        break;
                    case 7:
                        System.out.println("exiting without saving. goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("invalid option. try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("error: please enter a number!");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // method to add courses
    public static void addCourses(Scanner scanner, Department dept) {
        System.out.println("\n---ADD COURSES---");

        try {
            System.out.print("how many courses do you want to add? ");
            int numCourses = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= numCourses; i++) {
                System.out.println("\nenter details for course " + i + ":");

                System.out.print("course code (e.g., CS101): ");
                String code = scanner.nextLine();

                System.out.print("course name: ");
                String name = scanner.nextLine();

                System.out.print("credit units: ");
                int credits = scanner.nextInt();
                scanner.nextLine();

                Course course = new Course(code, name, credits);
                dept.addCourse(course);

                System.out.println("course added successfully!");
            }
        } catch (InputMismatchException e) {
            System.out.println("error: please enter a valid number!");
            scanner.nextLine();
        }
    }

    // method to add lecturers
    public static void addLecturers(Scanner scanner, Department dept) {
        System.out.println("\n---ADD LECTURERS---");

        try {
            System.out.print("how many lecturers do you want to add? ");
            int numLecturers = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= numLecturers; i++) {
                System.out.println("\nenter details for lecturer " + i + ":");

                System.out.print("lecturer ID: ");
                String id = scanner.nextLine();

                System.out.print("name: ");
                String name = scanner.nextLine();

                System.out.print("email: ");
                String email = scanner.nextLine();

                System.out.print("salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("subject they teach: ");
                String subject = scanner.nextLine();

                Lecturer lecturer = new Lecturer(id, name, email, salary, subject);
                dept.addLecturer(lecturer);

                System.out.println("lecturer added successfully!");
            }
        } catch (InputMismatchException e) {
            System.out.println("error: please enter a valid number for salary!");
            scanner.nextLine();
        }
    }

    // method to add students
    public static void addStudents(Scanner scanner, Department dept) {
        System.out.println("\n---ADD STUDENTS---");

        try {
            System.out.print("how many students do you want to add? ");
            int numStudents = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= numStudents; i++) {
                System.out.println("\nenter details for student " + i + ":");

                System.out.print("student ID: ");
                String id = scanner.nextLine();

                System.out.print("name: ");
                String name = scanner.nextLine();

                System.out.print("email: ");
                String email = scanner.nextLine();

                System.out.print("course: ");
                String course = scanner.nextLine();

                System.out.print("year (1-4): ");
                int year = scanner.nextInt();
                scanner.nextLine();

                if (year < 1 || year > 4) {
                    throw new IllegalArgumentException("year must be between 1 and 4");
                }

                Student student = new Student(id, name, email, course, year);
                dept.addStudent(student);

                System.out.println("student added successfully!");
            }
        } catch (InputMismatchException e) {
            System.out.println("error: please enter a valid number for year!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    // method to assign lecturers to courses
    public static void assignLecturersToCourses(Scanner scanner, Department dept) {
        if (dept.getCourses().isEmpty() || dept.getLecturers().isEmpty()) {
            System.out.println("need both courses and lecturers before assigning!");
            return;
        }

        System.out.println("\n---ASSIGN LECTURERS TO COURSES---");

        try {
            // show available courses
            System.out.println("\navailable courses:");
            for (int i = 0; i < dept.getCourses().size(); i++) {
                System.out.println((i+1) + ". " + dept.getCourses().get(i).getCourseName());
            }

            // show available lecturers
            System.out.println("\navailable lecturers:");
            for (int i = 0; i < dept.getLecturers().size(); i++) {
                System.out.println((i+1) + ". " + dept.getLecturers().get(i).getName());
            }

            System.out.print("\nhow many assignments do you want to make? ");
            int numAssignments = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= numAssignments; i++) {
                System.out.println("\nassignment " + i + ":");

                try {
                    System.out.print("enter course number: ");
                    int courseNum = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("enter lecturer number: ");
                    int lecturerNum = scanner.nextInt();
                    scanner.nextLine();

                    Course selectedCourse = dept.getCourses().get(courseNum - 1);
                    Lecturer selectedLecturer = dept.getLecturers().get(lecturerNum - 1);

                    selectedCourse.setLecturer(selectedLecturer);
                    System.out.println("assigned " + selectedLecturer.getName() + " to teach " + selectedCourse.getCourseName());

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("error: invalid course or lecturer number!");
                } catch (InputMismatchException e) {
                    System.out.println("error: please enter numbers only!");
                    scanner.nextLine();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("error: please enter a valid number!");
            scanner.nextLine();
        }
    }

    // display all data
    public static void displayAllData(Department dept) {
        System.out.println("\n=================================");
        System.out.println("DEPARTMENT SUMMARY");
        System.out.println("=================================");

        System.out.println("\n---DEPARTMENT INFO---");
        System.out.println("department: " + dept.getDepartmentName());
        System.out.println("total courses: " + dept.getCourses().size());
        System.out.println("total lecturers: " + dept.getLecturers().size());
        System.out.println("total students: " + dept.getStudents().size());

        // courses
        System.out.println("\n---COURSES---");
        if (dept.getCourses().isEmpty()) {
            System.out.println("no courses added.");
        } else {
            for (int i = 0; i < dept.getCourses().size(); i++) {
                Course c = dept.getCourses().get(i);
                String lecturerName = (c.getLecturer() != null) ? c.getLecturer().getName() : "not assigned";
                System.out.println((i+1) + ". " + c.getCourseCode() + " - " + c.getCourseName() +
                        " (" + c.getCreditUnits() + " credits) - lecturer: " + lecturerName);
            }
        }

        // lecturers
        System.out.println("\n---LECTURERS---");
        if (dept.getLecturers().isEmpty()) {
            System.out.println("no lecturers added.");
        } else {
            for (int i = 0; i < dept.getLecturers().size(); i++) {
                Lecturer l = dept.getLecturers().get(i);
                System.out.println((i+1) + ". " + l.getName() + " - " + l.getSubject() +
                        " - salary: UGX " + l.calculatePay());
            }
        }

        // students
        System.out.println("\n---STUDENTS---");
        if (dept.getStudents().isEmpty()) {
            System.out.println("no students added.");
        } else {
            for (int i = 0; i < dept.getStudents().size(); i++) {
                Student s = dept.getStudents().get(i);
                System.out.println((i+1) + ". " + s.getName() + " (ID: " + s.getId() + ") - " +
                        s.getCourse() + " - year " + s.getYear());
            }
        }

        // payroll
        System.out.println("\n---PAYROLL---");
        double totalSalary = 0;
        if (dept.getLecturers().isEmpty()) {
            System.out.println("no lecturers to calculate payroll.");
        } else {
            for (Lecturer l : dept.getLecturers()) {
                totalSalary += l.calculatePay();
            }
            System.out.println("total monthly payroll: UGX " + totalSalary);
        }

        // teaching session
        System.out.println("\n---TEACHING SESSION---");
        if (dept.getLecturers().isEmpty()) {
            System.out.println("no lecturers to teach.");
        } else {
            for (Lecturer l : dept.getLecturers()) {
                if (l.getSubject() != null && !l.getSubject().isEmpty()) {
                    l.teach();
                } else {
                    System.out.println(l.getName() + " has no subject assigned.");
                }
            }
        }
    }
}