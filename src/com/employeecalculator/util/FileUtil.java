package com.employeecalculator.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class FileUtil {
    private static final String SAVE_DIRECTORY = "saved_calculations";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd_HHmmss");
    private static final SimpleDateFormat DISPLAY_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void saveCalculation(String employeeName, Map<String, String> results) {
        // Create directory if it doesn't exist
        File directory = new File(SAVE_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Create a timestamp for the filename
        String timestamp = DATE_FORMAT.format(new Date());
        String filename = String.format("%s/%s_%s.txt", SAVE_DIRECTORY, employeeName.replace(" ", "_"), timestamp);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write header
            writer.write(String.format("Employee Salary Calculation - %s%n", DISPLAY_FORMAT.format(new Date())));
            writer.write("===================================\n\n");
            
            // Write all results
            writer.write(String.format("%-25s: %s%n", "Employee Name", employeeName));
            for (Map.Entry<String, String> entry : results.entrySet()) {
                String formattedKey = entry.getKey().replaceAll("([A-Z])", " $1");
                formattedKey = formattedKey.substring(0, 1).toUpperCase() + formattedKey.substring(1);
                writer.write(String.format("%-25s: %s%n", formattedKey, entry.getValue()));
            }
            
            writer.write("\n--- End of Calculation ---\n");
            
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save calculation: " + e.getMessage(), e);
        }
    }
}