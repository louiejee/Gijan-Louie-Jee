import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentRecordManagement {

    public static void main(String[] args) {
        Map<String, Student> studentRecords = new HashMap<>();
        Map<String, String> courses = initializeCourses();
        Map<String, String> departments = initializeDepartments();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Record Management App v1");
            System.out.println();
            System.out.println("Selection Menu:");
            System.out.println("----------------------------------");
            System.out.println("1. Create Student Record");
            System.out.println("0. Exit");
            System.out.println("----------------------------------");
            System.out.println();

            System.out.print("Enter Selection: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createStudentRecord(studentRecords, courses, departments, scanner);
                    displayStudentRecordMenu(studentRecords, courses, departments, scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void displayStudentRecordMenu(Map<String, Student> studentRecords, Map<String, String> courses, Map<String, String> departments, Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Record Management App v1");
            System.out.println();
            System.out.println("\nStudent Record Selection Menu:");
            System.out.println("----------------------------------");
            System.out.println("1. Update Student Profile Details");
            System.out.println("2. Update Student Course Details");
            System.out.println("3. Display Student Record");
            System.out.println("0. Exit");
            System.out.println("----------------------------------");
            System.out.println();

            System.out.print("Enter Selection: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    updateStudentProfileDetails(studentRecords, scanner);
                    break;
                case 2:
                    updateStudentCourseDetails(studentRecords, courses, departments, scanner);
                    break;
                case 3:
                    displayStudentDetails(studentRecords, scanner);
                    break;
                case 0:
                    System.out.println("Exiting the Student Record Selection Menu:");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static Map<String, String> initializeCourses() {
        Map<String, String> courses = new HashMap<>();
        courses.put("BSIT", "Bachelor of Science in Information Technology (College of Computer Studies Department)");
        courses.put("BSCS", "Bachelor of Science in Computer Science (College of Computer Studies Department)");
        courses.put("ACT", "Associate of Computer Technology (College of Computer Studies Department)");
        courses.put("BSME", "Bachelor of Science in Mechanical Engineering (College of Engineering Department)");
        courses.put("BSCE", "Bachelor of Science in Civil Engineering (College of Engineering Department)");
        return courses;
    }

    private static Map<String, String> initializeDepartments() {
        Map<String, String> departments = new HashMap<>();
        departments.put("CCS", "College of Computer Studies Department");
        departments.put("COE", "College of Engineering Department");
        return departments;
    }

    private static void createStudentRecord(Map<String, Student> studentRecords, Map<String, String> courses, Map<String, String> departments, Scanner scanner) {
        System.out.println("\nEnter Student Details:");
        System.out.println("----------------------");
        System.out.print("Enter Student ID No. : ");
        String studentId = scanner.nextLine();
        System.out.print("Enter First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Middle name: ");
        String middleName = scanner.nextLine();
        System.out.print("Enter Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Suffix: ");
        String suffix = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Input course code and validate it
        String courseCode;
        do {
            System.out.print("Enter course code (e.g., BSIT): ");
            courseCode = scanner.nextLine().toUpperCase();
        } while (!courses.containsKey(courseCode));

        String courseName = courses.get(courseCode); // Get the course name

        System.out.print("Enter Year Level: ");
        int yearLevel = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        // Get the department based on the course code
        String department = departments.get(courseCode);

        Student student = new Student(studentId, firstName, middleName, lastName, suffix, age, yearLevel, courseName, courseCode, department, phoneNumber, email);
        studentRecords.put(studentId, student);

        System.out.println("Student record for " + firstName + " " + lastName + " created successfully.");
    }

    private static void updateStudentProfileDetails(Map<String, Student> studentRecords, Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        String studentId = scanner.nextLine();
        if (studentRecords.containsKey(studentId)) {
            Student student = studentRecords.get(studentId);

            System.out.print("Update First Name: ");
            String newFirstName = scanner.nextLine();
            System.out.print("Update Middle Name: ");
            String newMiddleName = scanner.nextLine();
            System.out.print("Update Last Name: ");
            String newLastName = scanner.nextLine();
            System.out.print("Update Suffix: ");
            String newSuffix = scanner.nextLine();
            System.out.print("Update Age: ");
            int newAge = scanner.nextInt();
            System.out.print("Update Year Level: ");
            int newYearLevel = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Update Phone Number: ");
            String newPhoneNumber = scanner.nextLine();
            System.out.print("Update Email: ");
            String newEmail = scanner.nextLine();

            Student newStudent = new Student(student.getStudentId(), newFirstName, newMiddleName, newLastName, newSuffix, newAge, newYearLevel, student.getCourseName(), student.getCourseCode(), student.getDepartment(), newPhoneNumber, newEmail);

            // Update the student record
            studentRecords.put(studentId, newStudent);

            System.out.println("Student profile details for ID " + studentId + " updated successfully.");
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    private static void updateStudentCourseDetails(Map<String, Student> studentRecords, Map<String, String> courses, Map<String, String> departments, Scanner scanner) {
        System.out.print("Enter student ID to update course details: ");
        String studentId = scanner.nextLine();
        if (studentRecords.containsKey(studentId)) {
            // Display course selection menu
            System.out.println("Select Student Course Details to Update:");
            int courseChoice = 0;
            for (Map.Entry<String, String> entry : courses.entrySet()) {
                courseChoice++;
                System.out.println(courseChoice + ". " + entry.getValue() + " (" + entry.getKey() + ")");
            }
            System.out.print("Enter the number of the selected course: ");
            courseChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (courseChoice >= 1 && courseChoice <= courses.size()) {
                String[] courseCodes = courses.keySet().toArray(new String[0]);
                String newCourseCode = courseCodes[courseChoice - 1];
                String courseDescription = courses.get(newCourseCode);

                Student student = studentRecords.get(studentId);
                Student newStudent = new Student(
                    student.getStudentId(),
                    student.getFirstName(),
                    student.getMiddleName(),
                    student.getLastName(),
                    student.getSuffix(),
                    student.getAge(),
                    student.getYearLevel(),
                    courseDescription, // Update the course
                    newCourseCode,
                    departments.get(newCourseCode),
                    student.getPhoneNumber(),
                    student.getEmail()
                );

                // Update the student record
                studentRecords.put(studentId, newStudent);

                System.out.println("Student course details for ID " + studentId + " updated successfully.");
            } else {
                System.out.println("Invalid course choice.");
            }
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    private static void displayStudentDetails(Map<String, Student> studentRecords, Scanner scanner) {
        System.out.print("Enter student ID to display details: ");
        String studentId = scanner.nextLine();
        if (studentRecords.containsKey(studentId)) {
            Student student = studentRecords.get(studentId);

            System.out.println("\nStudent Profile Details:");
            System.out.println("Student ID No: " + student.getStudentId());
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Middle Name: " + student.getMiddleName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Suffix: " + student.getSuffix());
            System.out.println("Age: " + student.getAge());
            System.out.println("Year Level: " + student.getYearLevel());
            System.out.println("Phone Number: " + student.getPhoneNumber());
            System.out.println("Email: " + student.getEmail());

            System.out.println("\nStudent Course Details:");
            System.out.println("Course Name: " + student.getCourseName());
            System.out.println("Course Code: " + student.getCourseCode());
            System.out.println("Department: " + student.getDepartment());
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }
}
