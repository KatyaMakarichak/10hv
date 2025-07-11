
package com.example;

import java.io.*;
import java.util.regex.*;

public class PhoneValidator {
    public static void printValidPhoneNumbers(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        Pattern pattern = Pattern.compile("^(\(\d{3}\) \d{3}-\d{4}|\d{3}-\d{3}-\d{4})$");
        while ((line = reader.readLine()) != null) {
            if (pattern.matcher(line.trim()).matches()) {
                System.out.println(line);
            }
        }
        reader.close();
    }
}
