package com.employeecalculator.model;

import com.employeecalculator.util.FormatUtil;

import java.util.HashMap;
import java.util.Map;

public class SalaryCalculator {
    private static final double OVERTIME_RATE = 1.5;
    private static final double TAX_RATE = 0.20; // 20% tax
    private static final double HEALTH_INSURANCE_RATE = 0.05; // 5%
    private static final double RETIREMENT_RATE = 0.06; // 6%
    private static final double REGULAR_HOURS = 40.0;

    public Map<String, String> calculateSalary(Employee employee) {
        Map<String, String> results = new HashMap<>();
        
        double regularHours = Math.min(employee.getHoursWorked(), REGULAR_HOURS);
        double overtimeHours = Math.max(0, employee.getHoursWorked() - REGULAR_HOURS);
        double regularPay = regularHours * employee.getHourlyRate();
        double overtimePay = employee.hasOvertime() ? overtimeHours * employee.getHourlyRate() * OVERTIME_RATE : 0;
        double bonusAmount = employee.hasBonus() ? employee.getBonusAmount() : 0;
        double grossPay = regularPay + overtimePay + bonusAmount;
        
        double taxAmount = grossPay * TAX_RATE;
        double healthInsurance = grossPay * HEALTH_INSURANCE_RATE;
        double retirement = grossPay * RETIREMENT_RATE;
        double totalDeductions = taxAmount + healthInsurance + retirement;
        double netPay = grossPay - totalDeductions;
        
        // Format all results
        results.put("regularHours", FormatUtil.formatNumber(regularHours));
        results.put("overtimeHours", FormatUtil.formatNumber(overtimeHours));
        results.put("regularPay", FormatUtil.formatCurrency(regularPay));
        results.put("overtimePay", FormatUtil.formatCurrency(overtimePay));
        results.put("bonusAmount", FormatUtil.formatCurrency(bonusAmount));
        results.put("grossPay", FormatUtil.formatCurrency(grossPay));
        results.put("taxAmount", FormatUtil.formatCurrency(taxAmount));
        results.put("healthInsurance", FormatUtil.formatCurrency(healthInsurance));
        results.put("retirement", FormatUtil.formatCurrency(retirement));
        results.put("totalDeductions", FormatUtil.formatCurrency(totalDeductions));
        results.put("netPay", FormatUtil.formatCurrency(netPay));
        
        return results;
    }
}