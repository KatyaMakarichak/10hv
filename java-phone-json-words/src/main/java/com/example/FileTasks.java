package com.example;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileTasks {

    public static void printValidPhoneNumbers(String filePath) throws IOException {
        Pattern pattern = Pattern.compile("^\(\d{3}\) \d{3}-\d{4}$|^\d{3}-\d{3}-\d{4}$");
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) {
            if (pattern.matcher(line.trim()).matches()) {
                System.out.println(line.trim());
            }
        }
    }

    static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void convertFileToJson(String inputFilePath, String outputFilePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
        List<User> users = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).trim().split("\s+");
            if (parts.length >= 2) {
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                users.add(new User(name, age));
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        Files.write(Paths.get(outputFilePath), json.getBytes());
    }

    public static void countWordFrequencies(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        String[] words = content.trim().split("\s+");

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        freqMap.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Завдання 1: Валідні номери");
        printValidPhoneNumbers("file.txt");

        System.out.println("\nЗавдання 2: JSON");
        convertFileToJson("file.txt", "user.json");

        System.out.println("\nЗавдання 3: Частота слів");
        countWordFrequencies("words.txt");
    }
}
