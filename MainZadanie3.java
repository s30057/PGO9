import java.time.Year;

abstract class Person {
    private String firstName;
    private String lastName;
    private int birthdayYear;

    public Person(String firstName, String lastName, int birthdayYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayYear = birthdayYear;
    }

    public int getAge() {
        return Year.now().getValue() - birthdayYear;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

class Employee extends Person {
    private int hireYear;
    private String companyName;
    private double salary;

    public Employee(String firstName, String lastName, int birthdayYear, int hireYear, String companyName, double salary) {
        super(firstName, lastName, birthdayYear);
        this.hireYear = hireYear;
        this.companyName = companyName;
        this.salary = salary;
    }

    public int getJobSeniority() {
        return Year.now().getValue() - hireYear;
    }

    public double getSalary() {
        return salary;
    }
}

final class Manager extends Employee {
    private double bonus;

    public Manager(String firstName, String lastName, int birthdayYear, int hireYear, String companyName, double salary, double bonus) {
        super(firstName, lastName, birthdayYear, hireYear, companyName, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public String toString() {
        return "Manager with lastName " + super.toString().split(" ")[1] + " and age " + getAge() + " has salary " + getSalary();
    }
}

public class MainZadanie3 {
    public static void main(String[] args) {
        Manager manager = new Manager("Jan", "Kowalski", 1990, 2010, "PJATK", 2000d, 100d);
        System.out.println(manager);
    }
}
