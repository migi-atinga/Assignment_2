public class Main {
    public static void main(String[] args) {
        System.out.println("UNIVERSITY SYSTEM");
        System.out.println();

        // ===== CREATE DEPARTMENT =====
        Department csDept = new Department("Computer Science");
        System.out.println("Created " + csDept.getDepartmentName() + " Department\n");

        // ===== CREATE COURSES =====
        Course course1 = new Course("CS101", "Java Programming", 4);
        Course course2 = new Course("CS102", "Web Design", 3);
        Course course3 = new Course("CS201", "Database Systems", 4);

        csDept.addCourse(course1);
        csDept.addCourse(course2);
        csDept.addCourse(course3);
        System.out.println("Added 3 courses");

        // ===== CREATE LECTURERS =====
        Lecturer lect1 = new Lecturer("L001", "Dr. Musoke", "musoke@uni.ac.ug", 5000000, "Java");
        Lecturer lect2 = new Lecturer("L002", "Prof. Nakato", "nakato@uni.ac.ug", 6000000, "Web");
        Lecturer lect3 = new Lecturer("L003", "Mr. Okello", "okello@uni.ac.ug", 4500000, "Databases");

        csDept.addLecturer(lect1);
        csDept.addLecturer(lect2);
        csDept.addLecturer(lect3);
        System.out.println("Added 3 lecturers");

        // ===== ASSIGN LECTURERS TO COURSES =====
        course1.setLecturer(lect1);
        course2.setLecturer(lect2);
        course3.setLecturer(lect3);

        // ===== CREATE STUDENTS (using your original student IDs) =====
        Student std1 = new Student("221567", "Jeremy Okello", "jeremy@gmail.com", "Computer Science", 1);
        Student std2 = new Student("548543", "Lucy Nambi", "lucy@gmail.com", "Business", 2);
        Student std3 = new Student("221816", "Migi Atinga", "migi@gmail.com", "Computer Science", 3);
        Student std4 = new Student("S004", "Mary Akello", "mary@gmail.com", "Computer Science", 1);
        Student std5 = new Student("S005", "James Ochieng", "james@gmail.com", "Information Technology", 2);

        csDept.addStudent(std1);
        csDept.addStudent(std2);
        csDept.addStudent(std3);
        csDept.addStudent(std4);
        csDept.addStudent(std5);
        System.out.println("Added 5 students\n");

        // ===== DISPLAY ALL STUDENTS =====
        System.out.println("=== ALL STUDENTS ===");
        System.out.println("1. " + std1.getName() + " (ID: " + std1.getId() + ") - " + std1.getCourse() + " - Year " + std1.getYear() + " - " + std1.getRole());
        System.out.println("2. " + std2.getName() + " (ID: " + std2.getId() + ") - " + std2.getCourse() + " - Year " + std2.getYear() + " - " + std2.getRole());
        System.out.println("3. " + std3.getName() + " (ID: " + std3.getId() + ") - " + std3.getCourse() + " - Year " + std3.getYear() + " - " + std3.getRole());
        System.out.println("4. " + std4.getName() + " (ID: " + std4.getId() + ") - " + std4.getCourse() + " - Year " + std4.getYear() + " - " + std4.getRole());
        System.out.println("5. " + std5.getName() + " (ID: " + std5.getId() + ") - " + std5.getCourse() + " - Year " + std5.getYear() + " - " + std5.getRole());
        System.out.println();

        // ===== DISPLAY DEPARTMENT INFO =====
        System.out.println("=== DEPARTMENT SUMMARY ===");
        System.out.println("Department: " + csDept.getDepartmentName());
        System.out.println("Total Courses: " + csDept.getCourses().size());
        System.out.println("Total Lecturers: " + csDept.getLecturers().size());
        System.out.println("Total Students: " + csDept.getStudents().size());
        System.out.println();

        // ===== DISPLAY COURSES =====
        System.out.println("=== COURSES OFFERED ===");
        System.out.println("1. " + course1.getCourseCode() + " - " + course1.getCourseName() +
                " (" + course1.getCreditUnits() + " credits) - Lecturer: " + course1.getLecturer().getName());
        System.out.println("2. " + course2.getCourseCode() + " - " + course2.getCourseName() +
                " (" + course2.getCreditUnits() + " credits) - Lecturer: " + course2.getLecturer().getName());
        System.out.println("3. " + course3.getCourseCode() + " - " + course3.getCourseName() +
                " (" + course3.getCreditUnits() + " credits) - Lecturer: " + course3.getLecturer().getName());
        System.out.println();

        // ===== DISPLAY LECTURERS =====
        System.out.println("=== LECTURERS ===");
        System.out.println("1. " + lect1.getName() + " - " + lect1.getSubject() + " - Salary: UGX " + lect1.calculatePay());
        System.out.println("2. " + lect2.getName() + " - " + lect2.getSubject() + " - Salary: UGX " + lect2.calculatePay());
        System.out.println("3. " + lect3.getName() + " - " + lect3.getSubject() + " - Salary: UGX " + lect3.calculatePay());
        System.out.println();

        // ===== DEMONSTRATE PAYABLE INTERFACE =====
        System.out.println("=== PAYROLL ===");
        double totalSalary = 0;
        totalSalary = totalSalary + lect1.calculatePay();
        totalSalary = totalSalary + lect2.calculatePay();
        totalSalary = totalSalary + lect3.calculatePay();
        System.out.println("Total monthly payroll: UGX " + totalSalary);
        System.out.println();

        // ===== DEMONSTRATE TEACHABLE INTERFACE =====
        System.out.println("=== TEACHING SESSION ===");
        lect1.teach();
        lect2.teach();
        lect3.teach();
        System.out.println();

        // ===== DEMONSTRATE INHERITANCE =====
        System.out.println("=== PERSON ROLES ===");
        System.out.println(std1.getName() + " is a " + std1.getRole());
        System.out.println(lect1.getName() + " is a " + lect1.getRole());
        System.out.println();

        // ===== DEMONSTRATE ENCAPSULATION =====
        System.out.println("=== UPDATING INFORMATION ===");
        System.out.println(std1.getName() + " was in year " + std1.getYear());
        std1.setYear(2);
        System.out.println("Now " + std1.getName() + " is in year " + std1.getYear());

        System.out.println(std2.getName() + " was doing " + std2.getCourse());
        std2.setCourse("Information Technology");
        System.out.println("Now " + std2.getName() + " is doing " + std2.getCourse());
        System.out.println();

        System.out.println(lect1.getName() + " salary was UGX " + lect1.getSalary());
        lect1.setSalary(5500000);
        System.out.println("Now " + lect1.getName() + " salary is UGX " + lect1.getSalary());
        System.out.println();

        // ===== DEPARTMENT STATISTICS =====
        System.out.println("=== QUICK STATS ===");
        int csStudents = 0;
        int itStudents = 0;
        int bizStudents = 0;

        if (std1.getCourse().equals("Computer Science")) csStudents++;
        if (std2.getCourse().equals("Information Technology")) itStudents++;
        if (std3.getCourse().equals("Computer Science")) csStudents++;
        if (std4.getCourse().equals("Computer Science")) csStudents++;
        if (std5.getCourse().equals("Information Technology")) itStudents++;

        System.out.println("Computer Science students: " + csStudents);
        System.out.println("IT students: " + itStudents);
        System.out.println("Business students: " + bizStudents);

        System.out.println("\nPROGRAM COMPLETED");
    }
}