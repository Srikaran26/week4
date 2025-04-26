package ioStreams;

import java.io.*;

public class UserInfoSaver {
    public static void main(String[] args) {
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            
            String content = "Name: " + name + "\n" +
                             "Age: " + age + "\n" +
                             "Favorite Programming Language: " + language + "\n";

            writer = new FileWriter("user_info.txt");
            writer.write(content);

            System.out.println("\nUser information saved to 'user_info.txt' successfully!");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
        	
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error while closing resources: " + e.getMessage());
            }
        }
    }
}

