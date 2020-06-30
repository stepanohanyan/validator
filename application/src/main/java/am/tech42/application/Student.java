package am.tech42.application;

public class Student extends User {
	private String firstName;
	private String lastName;
	private int gpa;

	public Student(char[] username, char[] password, String firstName, String lastName, int gpa) {
		super(username, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
	}
}
