import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentRecordManagement {

    private static Map<String, Course> courses;

    public static void main(String[] args) {
        Map<String, Student> studentRecords = new HashMap<>();
        courses = initializeCourses();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Record Management App v1");
            System.out.println("Selection Menu:");
            System.out.println("----------------------------------");
            System.out.println("1. Create Student Record");
            System.out.println("0. Exit");
            System.out.println("----------------------------------");
            System.out.print("Enter Selection: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createStudentRecord(studentRecords, scanner);
                    displayStudentRecordMenu(studentRecords, scanner);
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

    private static Map<String, Course> initializeCourses() {
        Map<String, Course> courses = new HashMap<>();
        courses.put("BSIT", new Course("Bachelor of Science in Information Technology", "BSIT", "College of Computer Studies Department"));
        courses.put("BSCS", new Course("Bachelor of Science in Computer Science", "BSCS", "College of Computer Studies Department"));
        courses.put("ACT", new Course("Associate of Computer Technology", "ACT", "College of Computer Studies Department"));
        courses.put("BSME", new Course("Bachelor of Science in Mechanical Engineering", "BSME", "College of Engineering Department"));
        courses.put("BSCE", new Course("Bachelor of Science in Civil Engineering", "BSCE", "College of Engineering Department"));
        return courses;
    }

    private static void createStudentRecord(Map<String, Student> studentRecords, Scanner scanner) {
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

        String courseCode;
        do {
            System.out.print("Enter course code (e.g., BSIT): ");
            courseCode = scanner.nextLine().toUpperCase();
        } while (!courses.containsKey(courseCode));

        Course selectedCourse = courses.get(courseCode);

        System.out.print("Enter Year Level: ");
        int yearLevel = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Student student = new Student(studentId, firstName, middleName, lastName, suffix, age, yearLevel, selectedCourse, phoneNumber, email);
        studentRecords.put(studentId, student);
        System.out.println();
        System.out.println("Student record for " + firstName + " " + lastName + " created successfully.");
    }

    private static void displayStudentRecordMenu(Map<String, Student> studentRecords, Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Record Management App v1");
            System.out.println();
            System.out.println("Student Record Selection Menu:");
            System.out.println("----------------------------------");
            System.out.println("1. Update Student Profile Details");
            System.out.println("2. Update Student Course Details");
            System.out.println("3. Display Student Record");
            System.out.println("0. Exit");
            System.out.println("----------------------------------");
            System.out.print("Enter Selection: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    updateStudentProfileDetails(studentRecords, scanner);
                    break;
                case 2:
                    updateStudentCourseDetails(studentRecords, scanner);
                    break;
                case 3:
                    if (displayStudentDetails(studentRecords, scanner)) {
                        exit = true;
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void updateStudentProfileDetails(Map<String, Student> studentRecords, Scanner scanner) {
        System.out.print("Enter student ID to update profile details: ");
        String studentId = scanner.nextLine();
        if (studentRecords.containsKey(studentId)) {
            Student student = studentRecords.get(studentId);

            System.out.println("\nUpdating Profile Details for Student ID: " + student.getStudentId());
            System.out.println();
            System.out.println("Student Record Management App v1");
            System.out.println();
            System.out.println("Student Profile Details Update Selection Menu:");
            System.out.println("----------------------------------------------------");
            System.out.print("1. Update Student ID No. : ");
            String newStudentId = scanner.nextLine();
            
            if (!studentRecords.containsKey(newStudentId)) {
            studentRecords.remove(studentId); // Remove the old ID
            student.setStudentId(newStudentId); // Update the student's ID
            studentRecords.put(newStudentId, student); // Add with the new ID

            System.out.print("2. Update First Name: ");
            String newFirstName = scanner.nextLine();
            student.setFirstName(newFirstName);

            System.out.print("3. Update Middle Name: ");
            String newMiddleName = scanner.nextLine();
            student.setMiddleName(newMiddleName);

            System.out.print("4. Update Last Name: ");
            String newLastName = scanner.nextLine();
            student.setLastName(newLastName);

            System.out.print("5. Update Suffix: ");
            String newSuffix = scanner.nextLine();
            student.setSuffix(newSuffix);

            System.out.print("6. Update Age: ");
            int newAge = scanner.nextInt();
            student.setAge(newAge);

            System.out.print("7. Update Year Level: ");
            int newYearLevel = scanner.nextInt();
            student.setYearLevel(newYearLevel);
            scanner.nextLine(); // Consume the newline character

            System.out.print("8. Update Phone Number: ");
            String newPhoneNumber = scanner.nextLine();
            student.setPhoneNumber(newPhoneNumber);

            System.out.print("9. Update Email: ");
            String newEmail = scanner.nextLine();
            student.setEmail(newEmail);
            
            System.out.println("0. Return");
            System.out.println("----------------------------------------------------");


             System.out.println("Profile details updated successfully.");
        } else {
            System.out.println("The new Student ID is already in use. Please choose a different ID.");
        }
    } else {
        System.out.println("Student with ID " + studentId + " not found.");
    }
}
    private static void updateStudentCourseDetails(Map<String, Student> studentRecords, Scanner scanner) {
    System.out.print("Enter student ID to update course details: ");
    String studentId = scanner.nextLine();
    if (studentRecords.containsKey(studentId)) {
        Student student = studentRecords.get(studentId);

        System.out.println("\nUpdating Course Details for Student ID: " + student.getStudentId());

        // Display available courses with numbers
        int courseNumber = 1;
        Map<Integer, String> courseNumberToCode = new HashMap<>();
        for (Map.Entry<String, Course> entry : courses.entrySet()) {
            Course course = entry.getValue();
            String courseOption = courseNumber + ". " + course.getCourseName() + " (" + course.getCourseCode() + ")";
            courseNumberToCode.put(courseNumber, course.getCourseCode());
            System.out.println(courseOption);
            courseNumber++;
        }

        // Prompt the user to select a course by number
        System.out.print("Enter the number of the course to select a new course: ");
        int selectedCourseNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (courseNumberToCode.containsKey(selectedCourseNumber)) {
            String newCourseCode = courseNumberToCode.get(selectedCourseNumber);
            Course newCourse = courses.get(newCourseCode);
            student.setCourse(newCourse);
            System.out.println("Course details updated successfully.");
        } else {
            System.out.println("Invalid course number. Course details update failed.");
        }
    } else {
        System.out.println("Student with ID " + studentId + " not found.");
    }
}

    
    private static boolean displayStudentDetails(Map<String, Student> studentRecords, Scanner scanner) {
        System.out.print("Enter student ID to display details: ");
        String studentId = scanner.nextLine();
        if (studentRecords.containsKey(studentId)) {
            Student student = studentRecords.get(studentId);
            
            System.out.println("Student Record Management App v1");
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("0. Exit");
            System.out.println("----------------------------------------------------");
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
            System.out.println("Course Name: " + student.getCourse().getCourseName());
            System.out.println("Course Code: " + student.getCourse().getCourseCode());
            System.out.println("Department: " + student.getCourse().getDepartment());
            System.out.println("----------------------------------------------------");

            return false;
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
        return false;
    }
}
