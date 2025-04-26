package ioStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReader {
	public static void filereader(String filePath, String destinationPath) {
		try(FileInputStream fis=new FileInputStream(filePath); FileOutputStream fos=new FileOutputStream(destinationPath)){
			int data;
			while ((data=fis.read())!=-1) {
				fos.write(data);
			}
			System.out.println("File Copied Successfully");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String sourcePath="Sample.txt";
		String destinationPath="destination.txt";
		filereader(sourcePath,destinationPath);	
	}
}
