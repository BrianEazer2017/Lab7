import java.util.Scanner;

public class RegExValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inputName();
	}
	public static void inputName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first and last name, no titles: ");
		String inputName = sc.nextLine();
		if (validateName(inputName) == false) {
			System.out.println("Invalid input. Make sure you capitalize your name and only use letters.");
			inputName();
		}
		else {
		inputEmail(sc, inputName);
		}
	}
	private static boolean validateName(String inputName) {
		String regex = "^[A-Z][a-z']*\\s[A-Z][a-z']{0,28}";
		boolean answer = inputName.matches(regex);
		return answer;
	}
	public static void inputEmail(Scanner sc, String name) {
		System.out.println("Enter your email: ");
		String inputEmail = sc.nextLine();
		if (validateEmail(inputEmail) == false) {
			System.out.println("Invalid input. Make sure you enter a proper email address.");
			inputEmail(sc, name);
		} else {
			inputPhoneNumber(sc, name, inputEmail);
		}
	}
	public static boolean validateEmail(String inputEmail) {
		String regex = "^[a-zA-Z0-9]{5,30}@[a-zA-Z0-9]{5,10}.com";
		boolean answer = inputEmail.matches(regex);
		return answer;
	}
	private static void inputPhoneNumber(Scanner sc, String name, String email) {
		System.out.println("Enter your phone number, example 555-555-5555:");
		String inputPhoneNumber = sc.nextLine();
		if (validatePhoneNumber(inputPhoneNumber) == false) {
			System.out.println("Invalid input. Make sure you enter a proper phone number.");
			inputPhoneNumber(sc, name, email);
		} else {
			inputDate(sc, name, email, inputPhoneNumber);
		}
		
	}
	private static boolean validatePhoneNumber(String inputPhoneNumber) {
		// TODO Auto-generated method stub
		String regex = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
		boolean answer = inputPhoneNumber.matches(regex);
		return answer;
	}
	private static void inputDate(Scanner sc, String name, String email, String phoneNumber) {
		System.out.println("Enter the date using this format \"MM-DD-YYYY\" :");
		String inputDate = sc.nextLine();
		if (validateDate(inputDate) == false) {
			System.out.println("Invalid date. Make sure you follow the correct format:");
			inputDate(sc, name, email, phoneNumber);
		} else {
			inputHtmlElement(sc, name, email, phoneNumber, inputDate);
		}
	}
	private static boolean validateDate(String inputDate) {
		// TODO Auto-generated method stub
		String regex = "^\\d{2}-\\d{2}-\\d{4}$";
		boolean answer = inputDate.matches(regex);
		return answer;
	}
	private static void inputHtmlElement(Scanner sc, String name, String email, String phoneNumber, String date) {
		System.out.println("Enter opening and closing HTML tags:");
		String inputHtmlElement = sc.nextLine();
		if (validateHtmlElement(inputHtmlElement) == false) {
			System.out.println("Invalid HTML element");
			inputHtmlElement(sc, name, email, phoneNumber, date);
		} else {
			printAll(sc, name, email, phoneNumber, date, inputHtmlElement);
		}
	}
	private static boolean validateHtmlElement(String inputHtmlElement) {
		// TODO Auto-generated method stub
		String regex = "<([a-z0-9]+)>.*</\\1>";
		boolean answer = inputHtmlElement.matches(regex);
		return answer;
	}
	private static void printAll(Scanner sc, String name, String email, String phoneNumber, String date, String htmlElement) {
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Phone number: " + phoneNumber);
		System.out.println("Date: " + date);
		System.out.println("HTML element: " + htmlElement);
	}

}
