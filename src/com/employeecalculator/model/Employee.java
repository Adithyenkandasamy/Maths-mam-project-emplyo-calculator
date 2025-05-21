package com.employeecalculator.model;

public class Employee {
    private String name;
    private int age;
    private String position;
    private double hoursWorked;
    private double overtimeHours;
    private double hourlyRate;
    private boolean hasBonus;
    private double bonusAmount;

    public Employee(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    
    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    
    public double getOvertimeHours() { return overtimeHours; }
    public void setOvertimeHours(double overtimeHours) { this.overtimeHours = overtimeHours; }
    
    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    
    public boolean hasOvertime() { return overtimeHours > 0; }
    
    public boolean hasBonus() { return hasBonus; }
    public void setHasBonus(boolean hasBonus) { this.hasBonus = hasBonus; }
    
    public double getBonusAmount() { return bonusAmount; }
    public void setBonusAmount(double bonusAmount) { this.bonusAmount = bonusAmount; }
}