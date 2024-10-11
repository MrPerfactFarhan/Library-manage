//Here is the complete code for the Student Management System in Java:

Student.java

public class Student {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String course;
    private double gpa;

    public Student(int id, String name, String email, String phoneNumber, String course, double gpa) {
        (link unavailable) = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.gpa = gpa;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        (link unavailable) = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}


StudentDAO.java

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private List<Student> students;

    public StudentDAO() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}


StudentService.java

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public void removeStudent(int id) {
        studentDAO.removeStudent(id);
    }

    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}


Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Get Student");
            System.out.println("4. Get All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addStudent(studentService, scanner);
                    break;
                case 2:
                    removeStudent(studentService, scanner);
                    break;
                case 3:
                    getStudent(studentService, scanner);
                    break;
                case 4:
                    getAllStudents(studentService);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void addStudent(StudentService studentService, Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter student phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter student course: ");
        String course = scanner.nextLine();
        System.out.print("Enter student GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        Student student = new Student(id, name, email, phoneNumber, course, gpa);
        studentService.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private static void removeStudent(StudentService studentService, Scanner scanner) {
        System.out.print("Enter student ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        studentService.removeStudent(id);
