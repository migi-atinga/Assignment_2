public class Lecturer extends Person implements Payable, Teachable {
    private double salary;
    private String subject;

    public Lecturer(String id, String name, String email, double salary, String subject) {
        super(id, name, email);
        this.salary = salary;
        this.subject = subject;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getRole() {
        return "Lecturer";
    }

    @Override
    public double calculatePay() {
        return salary;
    }

    @Override
    public void teach() {
        System.out.println(getName() + " is teaching " + subject);
    }
}