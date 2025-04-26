package ioStreams;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // Path to your text file
        String filePath = "sample.txt"; // You can change this to your file path

        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Convert to lowercase and split by non-word characters
                String[] words = line.toLowerCase().split("\\W+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort entries by value (frequency) in descending order
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
            sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

