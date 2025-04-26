package ioStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ErrorLine {
    public static void main(String[] args) {
        String filePath = "Sample.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

