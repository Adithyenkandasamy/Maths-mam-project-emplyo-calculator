package com.employeecalculator.model;

/**
 * Contains all constant values used throughout the application.
 */
public class Constants {
    // Tax rates
    public static final double TAX_RATE_TIER1 = 0.10; // 10% for income <= 20000
    public static final double TAX_RATE_TIER2 = 0.15; // 15% for income 20001-50000
    public static final double TAX_RATE_TIER3 = 0.25; // 25% for income > 50000
    
    public static final double TAX_THRESHOLD_1 = 20000.0;
    public static final double TAX_THRESHOLD_2 = 50000.0;
    
    // Benefits rates
    public static final double HEALTH_INSURANCE_RATE = 0.05; // 5% of gross salary
    public static final double RETIREMENT_RATE = 0.06; // 6% of retirement
    
    // Regular work hours
    public static final double STANDARD_WORK_HOURS = 40.0;
    public static final double OVERTIME_MULTIPLIER = 1.5;
    
    // UI constants
    public static final String[] DEPARTMENTS = {
            "Engineering", "Marketing", "Sales", 
            "Human Resources", "Finance", "Operations"
    };
    
    // Regex patterns
    public static final String NUMERIC_PATTERN = "\\d*(\\.\\d*)?";
    
    // CSS styles
    public static final String PRIMARY_BUTTON_STYLE = 
            "-fx-background-color: #2d5c88; -fx-text-fill: white; -fx-font-weight: bold;";
    
    public static final String SECONDARY_BUTTON_STYLE = 
            "-fx-background-color: #e0e0e0; -fx-text-fill: #333333;";
    
    public static final String PRIMARY_TEXT_COLOR = "#2d5c88";
    public static final String BACKGROUND_COLOR = "#f5f5f7";
}