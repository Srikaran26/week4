package ExceptionHandling;
import java.util.Scanner;

class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}

public class AgeValdidator{
	
	public static void validateAge(int age) throws InvalidAgeException{
		if(age<18) {
			throw new InvalidAgeException("Age must be 18 or above");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your age");
		int age=sc.nextInt();
		
		try {
			validateAge(age);
			System.out.println("Access granted!");
		} catch(InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
	}
}
