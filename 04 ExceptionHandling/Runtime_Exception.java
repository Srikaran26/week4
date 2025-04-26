package ExceptionHandling;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runtime_Exception {
	public static void arthematic() {
		try{
			int a= 10/0;
		}catch(ArithmeticException e) {
			System.out.println("Arithmetic Exception");
		}
	}
	
	public static void ImputMismatch() {
		try{
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Input Mismatch");
		}
		
	}
	
	public static void main(String[] args) {
		arthematic();
		ImputMismatch();
	}
}
