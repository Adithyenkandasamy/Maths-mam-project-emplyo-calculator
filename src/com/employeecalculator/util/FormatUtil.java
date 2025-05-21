package com.employeecalculator.util;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatUtil {
    private static final Locale INDIA = new Locale("en", "IN");
    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(INDIA);
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance(INDIA);

    static {
        CURRENCY_FORMAT.setMinimumFractionDigits(2);
        CURRENCY_FORMAT.setMaximumFractionDigits(2);
        NUMBER_FORMAT.setMinimumFractionDigits(2);
        NUMBER_FORMAT.setMaximumFractionDigits(2);
    }

    public static void setIndianLocale() {
        Locale.setDefault(INDIA);
    }

    public static String formatCurrency(double amount) {
        return CURRENCY_FORMAT.format(amount);
    }

    public static String formatNumber(double number) {
        return NUMBER_FORMAT.format(number);
    }

    public static String formatDouble(double value) {
        return String.format("%.2f", value);
    }

    public static boolean isNumeric(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches("\\d*(\\.\\d*)?");
    }

    public static double parseDoubleOrZero(String text) {
        if (text == null || text.isEmpty() || !isNumeric(text)) {
            return 0.0;
        }
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}