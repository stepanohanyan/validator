package am.tech42.application;

import am.tech42.library.Validator;
import java.util.Scanner;
import java.util.List;

public class App {

    public static void main( String[] args ) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.print("Enter first name: ");
	String firstName = scanner.nextLine();

	System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
	
	System.out.print("Enter gpa: ");
        int gpa = scanner.nextInt();
	scanner.nextLine();

	System.out.print("Enter username: ");
        char[] username = scanner.nextLine().toCharArray();

	System.out.print("Enter password: ");
        char[] password = scanner.nextLine().toCharArray();

	Student student = new Student(username, password, firstName, lastName, gpa);
	
	try {
		List<String> errors = Validator.validate(student);
		for(String error: errors) {
			System.out.println(error);
		}
	} catch (IllegalAccessException e) {
		System.out.println("Something went wrong!");
	}
    }

}
