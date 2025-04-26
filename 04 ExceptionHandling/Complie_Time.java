package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Complie_Time {
	public static void main(String[] args) {
		String file_path="data.txt";
		try(BufferedReader br=new BufferedReader(new FileReader(file_path) )){
			String line;
			while((line= br.readLine())!=null) {
				System.out.println(line);
			}
		} catch(IOException e) {
			System.out.println("File not found");
		}
	}
}
