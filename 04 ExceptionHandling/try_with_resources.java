package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class try_with_resources {
	public static void main(String[] args) {
		String file_path="data.txt";
		try(BufferedReader reader=new BufferedReader(new FileReader(file_path))){
			String line;
			line= reader.readLine();
			System.out.println(line);
		}catch(IOException e) {
			System.out.println("Error reading file");
		}
	}
	
}
