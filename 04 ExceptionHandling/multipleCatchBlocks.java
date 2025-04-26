package ExceptionHandling;
import java.io.*;
import java.util.ArrayIndexOutOfBoundsException;

public class multipleCatchBlocks {
	public static void OutOfIndex(){
		int[] arr= {1,2,3};
		try {
			int n=arr.length;
			System.out.println(arr[2]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bounds");
		}
	}
	public static void nullpointer() {
		int[] arr= null;
		try {
			System.out.println(arr[0]);
		}catch(NullPointerException e) {
			System.out.println("Array is empty");
		}
	}
	public static void main(String[] args) {
		OutOfIndex();
		nullpointer();
	}
	
}
