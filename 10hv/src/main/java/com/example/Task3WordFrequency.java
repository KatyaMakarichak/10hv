package com.example;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Task3WordFrequency {
    public static void printWordFrequency(String filename) {
        Map<String, Integer> freq = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        freq.put(word, freq.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        freq.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
            .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}