public class Main {
    public static void main(String[] args) {
        System.out.println("UNIVERSITY SYSTEM");
        System.out.println();

        // create students
        Student std1 = new Student("221567", "Jeremy Okello", "jeremy@gmail.com", "Computer Science", 1);
        Student std2 = new Student("548543", "Lucy Nambi", "lucy@gmail.com", "Business", 2);
        Student std3 = new Student("221816", "Migi Atinga", "migi@gmail.com", "Computer Science", 3);

        // print student 1
        System.out.println("STUDENT 1");
        System.out.println("Name: " + std1.getName());
        System.out.println("ID: " + std1.getId());
        System.out.println("Email: " + std1.getEmail());
        System.out.println("Course: " + std1.getCourse());
        System.out.println("Year: " + std1.getYear());
        System.out.println("Role: " + std1.getRole());
        System.out.println();

        // print student 2
        System.out.println("STUDENT 2");
        System.out.println("Name: " + std2.getName());
        System.out.println("ID: " + std2.getId());
        System.out.println("Email: " + std2.getEmail());
        System.out.println("Course: " + std2.getCourse());
        System.out.println("Year: " + std2.getYear());
        System.out.println("Role: " + std2.getRole());
        System.out.println();

        // print student 3
        System.out.println("STUDENT 3");
        System.out.println("Name: " + std3.getName());
        System.out.println("ID: " + std3.getId());
        System.out.println("Email: " + std3.getEmail());
        System.out.println("Course: " + std3.getCourse());
        System.out.println("Year: " + std3.getYear());
        System.out.println("Role: " + std3.getRole());
        System.out.println();

        // show thier roles
        System.out.println(std1.getName() + " is a " + std1.getRole());
        System.out.println(std2.getName() + " is a " + std2.getRole());
        System.out.println(std3.getName() + " is a " + std3.getRole());
        System.out.println();

        // update year for std1
        System.out.println(std1.getName() + " was in year " + std1.getYear());
        std1.setYear(2);
        System.out.println("now " + std1.getName() + " is in year " + std1.getYear());
        System.out.println();

        // update course for std2
        System.out.println(std2.getName() + " was doing " + std2.getCourse());
        std2.setCourse("Information Technology");
        System.out.println("now " + std2.getName() + " is doing " + std2.getCourse());
        System.out.println();

        System.out.println("DONE!");
    }
}