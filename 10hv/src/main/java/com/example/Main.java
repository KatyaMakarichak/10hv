package com.example;

public class Main {
    public static void main(String[] args) throws Exception {
        Task1PhoneValidator.printValidPhones("file.txt");
        Task2UserToJson.convertUsers("file.txt", "user.json");
        Task3WordFrequency.printWordFrequency("words.txt");
    }
}