import java.util.Scanner;
import students.Student; 

public class studentInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("First Name: ");
        String firstName = sc.nextLine();

        System.out.println("Middle Name: ");
        String middleName = sc.nextLine();

        System.out.println("Last Name: ");
        String lastName = sc.nextLine();

        System.out.println("Suffix: ");
        String suffix = sc.nextLine();

        Student student = new Student(); 
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setLastName(lastName);
        student.setSuffix(suffix);

        System.out.println("Full Name: " + student.getFullName());
    }
}
