
package com.example;

import java.io.*;
import java.util.*;

public class WordCounter {
    public static void countWordFrequencies(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        Map<String, Integer> frequencyMap = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.trim().split("\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();

        frequencyMap.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
