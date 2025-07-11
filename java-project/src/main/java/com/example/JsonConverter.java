
package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.*;
import java.util.*;

public class JsonConverter {
    public static void convertFileToJson(String inputFile, String outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        List<User> users = new ArrayList<>();
        String line = reader.readLine(); // Пропускаємо заголовок

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\s+");
            if (parts.length == 2) {
                users.add(new User(parts[0], Integer.parseInt(parts[1])));
            }
        }
        reader.close();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(outputFile), users);
    }
}
